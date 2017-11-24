package com.dongyp.extend;

/**
 * Created by dongyp on 2017/7/11.
 */
public class Student extends Person {
    private String student;

    public Student (){
        this("一个参数");
        System.out.println("这是student类的空参构造器");
    }

    public Student (String str){
        System.out.println("这是student类的"+str+"构造器");
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }


}
