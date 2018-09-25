package com.oldboy.mybatis.test;

import com.oldboy.mybatis.Order;
import com.oldboy.mybatis.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestCRUD  {

    /**
     * 测试增删改查
     */
    @Test
    public void testInsert() throws IOException {

        //加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建会话工厂(builder模式)
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
        //开启会话，相当于连接
        SqlSession sess = sf.openSession();
        User u = new User() ;
        u.setName("tom");
        u.setAge(12);
        sess.insert("users.insert" , u) ;
        sess.commit();
        sess.close();
        System.out.println("ok");
    }



    @Test
    public void testUpdate() throws IOException {

        //加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建会话工厂(builder模式)
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
        //开启会话，相当于连接
        SqlSession sess = sf.openSession();
        User u = new User() ;
        u.setName("toms");
        u.setAge(122);
        u.setId(1);
        sess.update("users.update" , u) ;
        sess.commit();
        sess.close();
        System.out.println("ok");
    }

    @Test
    public void testSelectone2() throws IOException {

        //加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建会话工厂(builder模式)
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
        //开启会话，相当于连接
        SqlSession sess = sf.openSession();
        User u = sess.selectOne("users.selectById", 1);
        sess.commit();
        sess.close();

    }


    @Test
    public void testInsert2() throws IOException {

        //加载配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        //创建会话工厂(builder模式)
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
        //开启会话，相当于连接
        SqlSession sess = sf.openSession();
        User u = new User();
        u.setId(1);
        Order o = new Order();
        o.setOrderNo("no001");
        o.setPrice(2000);
        //设置关联关系
        o.setUser(u);
        sess.insert("orders.insert" , o) ;
    }

}

