package com.wushengde.myselfmybatis;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestMybatis {
	//���ԣ�����ID��ѯ��ID����Ӧ���û���
	public static void main(String[] args)throws IOException {
		String resource="conf.xml";
		InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=factory.openSession();
		String statement="com.wushengde.myselfmybatis.userMapper.getUser";
		User user =session.selectOne(statement, 1);
		session.close();
		System.out.println(user);
	}
	//���ԣ������ݿ��в���һ�����ݣ�
	@Test
	public void addUser(){
		String resource="conf.xml";
		InputStream resourceAsStream = TestMybatis.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(resourceAsStream);
		SqlSession session=factory.openSession();
		String statement="com.wushengde.myselfmybatis.userMapper.addUser";
		int insert=session.insert(statement, new User(-1,"����",15));
		session.commit();
		session.close();
		System.out.println(insert);
		
	}
	//���ԣ��������ݿ��е�һ����Ϣ��
	@Test
	public void updateUser(){
		String resource="conf.xml";
		InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=factory.openSession();
		String statement="com.wushengde.myselfmybatis.userMapper.updateUser";
		int update =session.update(statement, new User(1, "����", 15));
		session.commit();
		session.close();
		System.out.println(update);
	}
	//���ԣ���ѯ���ݿ������е���Ϣ��
	@Test
	public void getAllUsers(){
		String resource="conf.xml";
		InputStream inputStream = TestMybatis.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=factory.openSession();
		String statement="com.wushengde.myselfmybatis.userMapper.getAllUsers";
		List<User> list=session.selectList(statement);
		session.close();
		System.out.println(list);
	}
	
}
