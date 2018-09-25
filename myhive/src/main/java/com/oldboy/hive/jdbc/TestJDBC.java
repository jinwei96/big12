package com.oldboy.hive.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) throws Exception {
        Class.forName("org.apache.hive.jdbc.HiveDriver");

        String url = "jdbc:hive2://192.168.190.101:10000/big12";

        Connection conn = DriverManager.getConnection(url);

        Statement stat = conn.createStatement();

        ResultSet rs = stat.executeQuery("select * from duowan limit 20");

        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String pass = rs.getString(3);
            String mail = rs.getString(4);
            String nickname = rs.getString(5);
            System.out.println(id + "/" + name + "/" + pass + "/" + mail + "/" + nickname);
        }
        rs.close();
        stat.close();
        conn.close();
    }
}
