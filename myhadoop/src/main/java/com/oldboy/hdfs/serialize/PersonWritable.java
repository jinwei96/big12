package com.oldboy.hdfs.serialize;

import org.apache.hadoop.io.Writable;

import java.io.*;

public class PersonWritable implements Writable {

    private Person person;

    public PersonWritable() {
    }

    public PersonWritable(Person person) {

        this.person = person;
    }

    public void setPerson(Person person) {

        this.person = person;
    }

    public Person getPerson() {

        return person;
    }



    public void write(DataOutput out) throws IOException {
        //序列化name字段
        out.writeUTF(person.getName());
        //序列化age字段
        out.writeInt(person.getAge());
    }

    public void readFields(DataInput in) throws IOException {
        person = new Person();
        person.setName(in.readUTF());
        person.setAge(in.readInt());
    }
}
