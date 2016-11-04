package com.wushengde.myselfmybatis.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.wushengde.myselfmybatis.bean.Order;

public class TestOrder {
	public static void main(String[] args) {
		String resource="conf.xml";
		InputStream inputStream=TestOrder.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=factory.openSession();
		String statement="com.wushengde.myselfmybatis.test.orderMapper.getOrder";
		Order order=session.selectOne(statement, 1);
		session.close();
		System.out.println(order);
	}
}
