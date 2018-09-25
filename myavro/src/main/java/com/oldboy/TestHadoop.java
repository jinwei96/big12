package com.oldboy;

import org.junit.Test;
import tutorialspoint.com.Emp;
import tutorialspoint.com.EmpWritable;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestHadoop {

    @Test
    public void testSerial() throws Exception{

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("h:/practice/avro/emp.hadoop"));

        EmpWritable ew = new EmpWritable();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Emp emp = new Emp();

            emp.setId(i);
            emp.setName("tom"+i);
            emp.setAge(i % 100);
            emp.setSalary(20000);
            emp.setAddress("昌平");
            ew.setEmp(emp);
            ew.write(dos);
        }
        System.out.println(System.currentTimeMillis() - start);






        dos.close();

    }

    @Test
    public void testDeserial() throws Exception{

        DataInputStream dis = new DataInputStream(new FileInputStream("h:/practice/avro/emp.hadoop"));

        EmpWritable ew = new EmpWritable();

        ew.readFields(dis);

        Emp emp = ew.getEmp();

        System.out.println(emp);

    }
}
