package com.oldboy;

import org.junit.Test;
import tutorialspoint.com.Emp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestJava {

    @Test
    public void testSerial() throws Exception{
        
        Long time = System.currentTimeMillis();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("H:/practice/avro/emp.java"));
        for (int i = 0; i < 1000000; i++) {
            Emp emp = new Emp();

            emp.setId(i);
            emp.setName("tom"+i);
            emp.setAge(i % 100);
            emp.setSalary(20000);
            emp.setAddress("昌平");
            oos.writeObject(emp);
        }

        System.out.println(System.currentTimeMillis() - time);



        oos.close();

    }

    @Test
    public void testDeserial() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("H:/practice/avro/emp.java"));
        Long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Emp emp = (Emp) ois.readObject();
        }
        System.out.println(System.currentTimeMillis() - time);


        ois.close();
    }

}
