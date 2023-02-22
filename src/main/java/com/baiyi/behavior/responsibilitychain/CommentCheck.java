package com.baiyi.behavior.responsibilitychain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 评论检测
 * @author: BaiYi
 * @date: 2022/10/18 21:40
 */
public class CommentCheck {
    public static void main(String[] args) {
        Comment comment1 = new Comment("理性爱国......省略1000字", "baiyi");
        // 方案一实现
        // 字符长度限制
        comment1.msg = comment1.msg.substring(0, Math.min(500, comment1.msg.length()));
        // 敏感词过滤
        comment1.msg = comment1.msg.replaceAll("性爱", "**");
        // 特殊字符过滤
        comment1.msg = comment1.msg.replaceAll("<", "&lt;");
        comment1.msg = comment1.msg.replaceAll(">", "&gt;");
        System.out.println("comment1 = " + comment1);

        // 方案二：存在弊端，后续需求越来越多时，这些代码会越来越繁琐
        Comment comment2 = new Comment("理性爱国......省略1000字", "baiyi");
        new MaxLengthFilter().doFilter(comment2);
        new SensitiveFilter().doFilter(comment2);
        new IllegalFilter().doFilter(comment2);
        System.out.println("comment2 = " + comment2);

        // 方案三
        Comment comment3 = new Comment("理性爱国......省略1000字", "baiyi");
        List<Filter> list = new ArrayList<>();
        list.add(new MaxLengthFilter());
        list.add(new SensitiveFilter());
        list.add(new IllegalFilter());
        list.forEach(filter -> filter.doFilter(comment3));
        System.out.println("comment3 = " + comment3);

        // 方案四 引出过滤器链（责任链）
        Comment comment4 = new Comment("理性爱国......省略1000字", "baiyi");
        FilterChain chain = new FilterChain();
        chain.addFilter(new MaxLengthFilter());
        FilterChain chain1 = new FilterChain();
        chain1.addFilter(new SensitiveFilter());
        chain1.addFilter(new IllegalFilter());
        chain.addFilter(chain1);

        Filter filter = chain;
        filter.doFilter(comment4);
        System.out.println("comment4 = " + comment4);

        // 黑名单过滤
        Comment comment5 = new Comment("理性爱国......省略1000字", "白衣");
        BlackFilter blackFilter = new BlackFilter(chain);
        blackFilter.doFilter(comment5);
        System.out.println("comment5 = " + comment5);


    }

    /**
     * 过滤器
     */
    public interface Filter {
        void doFilter(Comment comment);
    }

    /**
     * 过滤链 数组链条
     */
    static class FilterChain implements Filter{
        List<Filter> list = new ArrayList<>();

        public void addFilter(Filter filter) {
            list.add(filter);
        }

        public void doFilter(Comment comment) {
            list.forEach(filter -> filter.doFilter(comment));
        }
    }

    /**
     * 字符长度过滤
     */
    static class MaxLengthFilter implements Filter {
        @Override
        public void doFilter(Comment comment) {
            comment.msg = comment.msg.substring(0, Math.min(100, comment.msg.length()));
        }
    }

    /**
     * 敏感词过滤
     */
    static class SensitiveFilter implements Filter {
        @Override
        public void doFilter(Comment comment) {
            comment.msg = comment.msg.replaceAll("性爱", "**");
        }
    }

    /**
     * 特殊字符过滤
     */
    static class IllegalFilter implements Filter {
        @Override
        public void doFilter(Comment comment) {
            comment.msg = comment.msg.replaceAll("<", "&lt;");
            comment.msg = comment.msg.replaceAll(">", "&gt;");
        }
    }

    /**
     * 黑名单过滤 -- 引用过滤器链
     */
    static class BlackFilter implements Filter {
        Filter filter;

        public BlackFilter(Filter filter) {
            this.filter = filter;
        }

        @Override
        public void doFilter(Comment comment) {
            if (comment.user.equals("白衣")) {
                // 不需要再往下执行了
                return;
            }
            // 超时过滤
            // 前置验证
            filter.doFilter(comment);
            // 后置验证
        }
    }

    /**
     * 评论实体
     */
    @Data
    @NoArgsConstructor
    public static class Comment {
        String msg;
        String user;

        public Comment(String msg, String user) {
            this.msg = msg;
            this.user = user;
        }
    }

    /**
     * 增强（包装）
     */
    @Data
    @NoArgsConstructor
    public static class CommentWrapper extends Comment {
        // 增强
        private String userId;

        public CommentWrapper(String msg, String user) {
            this.msg = msg;
            this.user = user;
        }
    }
}
