package com.wushengde.myselfmybatis.test2016110901;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestUser {
	public static void main(String[] args) {
		String resource="conf.xml";
		InputStream inputStream = TestUser.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=factory.openSession();
		String statement="com.wushengde.myselfmybatis.test2016110901.userMapper.getUserCount";
		Map<String, Integer> parameterMap=new HashMap<String,Integer>();
		parameterMap.put("sexid", 1);
		parameterMap.put("usercount", -1);
		session.selectOne(statement, parameterMap);
		Integer result=parameterMap.get("usercount");
		System.out.println(result);
	}
}
