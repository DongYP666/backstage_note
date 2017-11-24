package com.dongyp.keyWord;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2017/11/8
 */

/**
 *  1.==
 *      1）基本数据类型：根据基本数据类型判断是否相等，相等返回true，不等返回false
 *      2) 引用数据类型：比较引用对象的地址值是否相等
 *
 *  2.equals()
 *      存在于java.lang.Object类
 *      只能处理引用类型变量
 *      public boolean equals(Object obj) { return (this == obj); }
 *      在Object类中发现,equals()仍然比较的是两个引用对象的地址值是否相等
 *
 *      像String包装类，File类，Date类这些重写了Object类的equals()方法，比较的是两个对象的实体对象是否相等
 */
public class equals {
    public static void main(String[] args) {
        equals equals = new equals();
        equals.test1();

        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        String str1 = new String("AA");
        String str2 = new String("AA");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));//String类重写了Object类中的equals()
    }

    private void test1(){
        //1）基本数据类型：根据基本数据类型判断是否相等，相等返回true，不等返回false
        int i = 12;
        int j = 12;
        System.out.println(i == j);
        char k = 12;
        System.out.println(i == j);
        float f = 12.0F;
        System.out.println(i == j);

        int m = 65;
        char n = 'A';
        System.out.println(m == n);

        //2) 引用数据类型：比较引用对象的地址 值是否相等
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1 == o2);
    }
}

class Person{
}
