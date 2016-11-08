package com.wushengde.myselfmybatis.test2016110901;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wushengde.myselfmybatis.bean.ConditionUser;
import com.wushengde.myselfmybatis.bean.User;

public class TestUser {
	public static void main(String[] args) {
		String resource="conf.xml";
		InputStream inputStream = TestUser.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=factory.openSession();
		String statement="com.wushengde.myselfmybatis.test2016110901.userMapper.getUserCount";
		
	}
}
