package com.baiyi.behavior.mediator;


/**
 * @description: 监控系统上下文
 * @author: BaiYi
 * @date: 2022/10/18 21:10
 */
public class AgentContext {
    Collect[] collects;
    Filter[] filters;
    Upload[] uploads;

    /**
     * 采集到日志之后进行过滤、上报
     *
     * @param log 采集日志
     */
    public void addLog(Object log) {
        for (Filter filter : filters) {
            log = filter.doFilter(log);
        }
        // 选择其中一个进行上报 具体实现看业务需求
        Upload upload = uploads[0];
        upload.doUpload(log);
    }

    /**
     * 业务高峰期，采集系统需要停多久秒
     *
     * @param sleepSecond 停采集秒数
     */
    public void pauseCollect(int sleepSecond) {
        for (Collect collect : collects) {
            collect.stop();
        }
        // 睡眠一会，再重新开始采集
        new Thread(() -> {
            try {
                Thread.sleep(sleepSecond * 1000L);
                for (Collect collect : collects) {
                    collect.start();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    /**
     * 采集组件
     */
    public interface Collect {
        void start();

        void stop();
    }

    /**
     * 过滤组件
     */
    public interface Filter {
        Object doFilter(Object log);
    }

    /**
     * 上报组件
     */
    public interface Upload {
        void doUpload(Object log);
    }
}
