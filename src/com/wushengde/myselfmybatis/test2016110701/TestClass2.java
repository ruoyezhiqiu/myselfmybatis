package com.wushengde.myselfmybatis.test2016110701;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wushengde.myselfmybatis.bean.Classes;

public class TestClass2 {
	public static void main(String[] args) {
		String resource="conf.xml";
		InputStream inputStream = TestClass2.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=factory.openSession();
		String statement="com.wushengde.myselfmybatis.test20161107.classMapper.getClass2";
		
		Classes classes=session.selectOne(statement, 2);
		session.close();
		System.out.println(classes);
		
	}
}
