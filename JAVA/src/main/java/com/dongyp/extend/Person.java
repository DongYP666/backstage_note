package com.dongyp.extend;

/**
 * Created by dongyp on 2017/7/11.
 */
public class Person {
    private String name;

    private Integer age;

    public Person(){
        System.out.println("这是Person的空参构造器！");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
