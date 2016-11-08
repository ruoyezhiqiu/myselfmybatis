package com.wushengde.myselfmybatis.test2016110702;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wushengde.myselfmybatis.bean.ConditionUser;
import com.wushengde.myselfmybatis.bean.User;

public class TestUser {
	public static void main(String[] args) {
		String name=null;
		String resource="conf.xml";
		ConditionUser conditionUser=new ConditionUser("%"+name+"%",13,19);
		InputStream inputStream = TestUser.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=factory.openSession();
		String statement="com.wushengde.myselfmybatis.test2016110702.userMapper.getUser";
		List<User> list=session.selectList(statement, conditionUser);
		session.close();
		System.out.println(list);
	}
}
