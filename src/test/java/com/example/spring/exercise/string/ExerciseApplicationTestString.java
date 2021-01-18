package com.example.spring.exercise.string;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExerciseApplicationTestString {
    @Test
    void contextLoads() {
        System.out.println(ExerciseApplicationTestString.class+"----"+"123");
    }
    //创建字符串
    //String 创建的字符串存储在公共池中，而 new 创建的字符串对象在堆上：
    @Test
    void createStr(){
        String s1 = "Runoob";              // String 直接创建
        String s2 = "Runoob";              // String 直接创建
        String s3 = s1;                    // 相同引用
        String s4 = new String("Runoob");   // String 对象创建
        String s5 = new String("Runoob");   // String 对象创建
    }
    //连接字符串
    @Test
    void connectStr(){
        String string1 = "菜鸟教程网址：";
        System.out.println("1、" + string1 + "www.runoob.com");
    }
    //创建格式化字符串
    @Test
    void formatStr(){
        System.out.printf("浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                "is %s", 1.5, 25, "stringVar");
        String fs;
        fs = String.format("浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                " %s", 1.5, 25, "stringVar");
    }
    //常用方法
    @Test
    void commonMethod(){
        String string = "abcd";
        String string2 = "abcd";
        String string3 = new String("abcd");
        System.out.println(string==string2);
        System.out.println(string==string3);
        System.out.println(string.equals(string3));
        System.out.println(string.hashCode());
        System.out.println(string3.hashCode());
    }
    //8大基本类型
    @Test
    void baseType(){
        // byte

        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
        System.out.println("包装类：java.lang.Byte");
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
        System.out.println();

        // short
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
        System.out.println("包装类：java.lang.Short");
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
        System.out.println();

        // int
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
        System.out.println("包装类：java.lang.Integer");
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println();

        // long
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
        System.out.println("包装类：java.lang.Long");
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
        System.out.println();

        // float
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
        System.out.println("包装类：java.lang.Float");
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
        System.out.println("包装类：java.lang.Double");
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
        System.out.println("包装类：java.lang.Character");
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
        System.out.println("最小值：Character.MIN_VALUE="
                + (int) Character.MIN_VALUE);
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
        System.out.println("最大值：Character.MAX_VALUE="+ (int) Character.MAX_VALUE);
    }

    @Test
    void Test() throws Throwable {
        int [] i = {0,1};
        System.out.println(i.length);
    }
}
