package com.oldboy.hdfs.serialize;

import org.junit.Test;

import java.io.*;

public class TestPeron {

    //测试序列化
    @Test
    public void testSerial() throws Exception {
        Person p = new Person("tom", 20);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("h:/practice/serial/person.j"));

        oos.writeObject(p);

        oos.close();
    }

    //测试反序列化
    @Test
    public void testDeserial() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("h:/practice/serial/person.j"));

        Person p = (Person) ois.readObject();
        System.out.println(p);
        ois.close();
    }
}
