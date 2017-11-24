package com.dongyp.constructor; /**
 * Created by dongyp on 2017/7/3.
 */

/**
 * 构造器
 *
 * 构造器的作用:创建对象,初始化对象属性
 *
 * 1.设计类时，若不显式的声明类的构造器，程序会默认的提供一个空参的构造器
 * 2.一旦显式的提供构造器，那么默认的构造器就不再提供
 * 3.构造器没有返回值
 * 4.类的多个构造之间构成重载
 *
 * 类属性的赋值顺序: 1.属性的默认初始化 2.属性的显示初始化 3.通过构造器给属性初始化 4.通过"对象.方法"的方式赋值
 */
public class Constructor {
    public static void main(String[] args) {
        Person person = new Person("初始化名称",20);
        System.out.println(person);//person的地址
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getSex());
        System.out.println(person.getTest());
    }
}

class Person{
    //属性
    private String name;//1.属性的默认初始化
    private Integer age = 18;//2.属性的显示初始化
    private Integer sex;
    private String test;

    //构造器
    //3.通过构造器给属性初始化
    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    //方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}