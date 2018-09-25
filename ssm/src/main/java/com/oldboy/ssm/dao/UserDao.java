package com.oldboy.ssm.dao;

import com.oldboy.ssm.domain.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * userdao
 */
@Repository("userDao")
public class UserDao extends SqlSessionDaoSupport{

    public void insert(User user){
        getSqlSession().insert("users.insert" , user) ;
    }

    @Resource(name="sessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public void delete(Integer id){
        getSqlSession().delete("users.delete" , id) ;
    }

    public User findById(Integer id){
        return getSqlSession().selectOne("users.findById" , id) ;
    }
    public List<User> findAll(){
        return getSqlSession().selectList("users.findAll");
    }

    public void update(User user ){
        getSqlSession().update("user.update",user);
    }
}