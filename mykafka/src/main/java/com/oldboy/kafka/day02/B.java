package com.oldboy.kafka.day02;

public class B extends A{
    public static void main(String[] args) {
        Class clazz = B.class;
        Class class1 = A.class;
        System.out.println(class1.isAssignableFrom(clazz));
    }
}
