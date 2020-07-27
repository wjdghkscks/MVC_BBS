package com.ict.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {
	
	// MyBatis 사용을 위해 SqlSession 클래스가 필요
	// SqlSession 클래스를 사용하기 위해서는 SqlSessionFactory 클래스가 필요
	static private SqlSessionFactory factory;
	
	// static 초기화
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(
					Resources.getResourceAsReader("com/ict/db/config.xml"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}
