package com.dongyp.polymorphic;

/**
 * Copyright (C), 2014-2015, 深圳云集智造系统技术有限公司
 *
 * @Title:
 * @Description:
 * @Author by dongyp
 * @date on 2017/11/7
 */

/**
 * 多态，所谓多态就是指一个类实例的相同方法在不同情形有不同表现形式。
 * Java中有两种形式可以实现多态。继承和接口。
 * 1）方法的重载与重写 2）子类对象的多态性
 *
 * 子类对象多态性有三个必要条件：继承、重写、向上转型。
 *
 * 当超类对象引用变量引用子类对象时，被引用对象的类型而不是引用变量的类型决定了调用谁的成员方法，但是这个被调用的方法必须是在超类中定义过的，也就是说被子类覆盖的方法。
 *
 * 方法调用的优先问题 ，优先级由高到低依次为：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)
 *
 * 子类对象的多态性，并不适用于属性
 */
public class Polymophic {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println("1) " + a1.show(b));
        System.out.println("2) " + a1.show(c));
        System.out.println("3) " + a1.show(d));
        System.out.println("4) " + a2.show(b));
        System.out.println("5) " + a2.show(c));
        System.out.println("6) " + a2.show(d));
        System.out.println("7) " + b.show(b));
        System.out.println("8) " + b.show(c));
        System.out.println("9) " + b.show(d));
    }
}

class A {
    public String show(D obj) {
        return ("A and D");
    }

    public String show(A obj) {
        return ("A and A");
    }
}

class B extends A {
    public String show(B obj) {
        return ("B and B");
    }

    public String show(A obj) {
        return ("B and A");
    }
}

class C extends B {
}

class D extends B {
}
