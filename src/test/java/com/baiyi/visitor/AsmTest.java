package com.baiyi.visitor;

import jdk.internal.org.objectweb.asm.*;
import jdk.internal.org.objectweb.asm.util.TraceClassVisitor;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * @description: ASM 访问者模式测试类
 * @author: BaiYi
 * @date: 2022/10/17 22:27
 */
public class AsmTest {

    /**
     * 用于测试: ASM 读数据
     */
    @Test
    void testReader() throws IOException {
        byte[] bytes = Files.readAllBytes(new File("/Users/baiyi/github/designpattern/target/test-classes/com/baiyi" +
                "/visitor/Hello.class").toPath());
        ClassReader reader = new ClassReader(bytes);
        reader.accept(new ClassVisitor(Opcodes.ASM5) {

            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String signature,
                                             String[] exceptions) {
                System.out.println(name);
                return new MethodVisitor(Opcodes.ASM5) {
                    int line;

                    @Override
                    public void visitLineNumber(int line, Label start) {
                        this.line = line;
                    }

                    @Override
                    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                        System.out.println("执行的方法：" + line + ":" + owner + ":" + name);
                    }
                };
            }
        }, ClassReader.EXPAND_FRAMES);
    }

    /**
     * 用于测试:  ASM 写
     */
    @Test
    void testWriter() throws IOException {
        byte[] bytes = Files.readAllBytes(new File("/Users/baiyi/github/designpattern/target/test-classes/com/baiyi" +
                "/visitor/Hello.class").toPath());
        ClassReader reader = new ClassReader(bytes);
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        reader.accept(writer, ClassReader.EXPAND_FRAMES);

        // 方法的拷贝 自动生成一个 sayHello2 方法
        reader.accept(new ClassVisitor(Opcodes.ASM5) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String signature,
                                             String[] exceptions) {
                if (name.equals("sayHello")) {
                    return writer.visitMethod(access, "sayHello2", desc, signature, exceptions);
                }
                return null;
            }
        }, ClassReader.EXPAND_FRAMES);

        byte[] newBytes = writer.toByteArray();
        Files.write(new File(System.getProperty("user.dir") + "/target/hello2.class")
                .toPath(), newBytes);
    }

    /**
     * 用于测试: 打印所有的指令码
     */
    @Test
    void test_read_class_and_print_bytes() throws IOException {
        byte[] bytes = Files.readAllBytes(new File("/Users/baiyi/github/designpattern/target/test-classes/com/baiyi" +
                "/visitor/Hello.class").toPath());
        ClassReader reader = new ClassReader(bytes);
        reader.accept(new TraceClassVisitor(new PrintWriter(System.out)), ClassReader.EXPAND_FRAMES);
    }

    /**
     * 用于测试:
     */
    @Test
    public void test() {
        @Data
        @AllArgsConstructor
       class User {
           private String name;
           private Integer id;
       }

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("baiyi1", 1));
        users.add(new User("baiyi2", 2));
        users.add(new User("baiyi3", 3));
        users.add(new User("baiyi4", 4));
        users.add(new User("baiyi5", 5));
        users.stream()
                .filter(x -> x.getId() > 3)
                .filter(x -> x.getName().startsWith("baiyi"))
                .forEach(System.out::println);
    }
}
