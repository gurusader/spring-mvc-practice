package com.gurusader.springmvc.database;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class SqlSessionFactoryTest {
	@Inject
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void test() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println(sqlSession);
		sqlSession.close();
	}
}
