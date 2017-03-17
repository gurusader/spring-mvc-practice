package com.gurusader.springmvc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class JdbcTest {
	@Value("#{jdbc.driver}")
	private String driver;

	@Value("#{jdbc.url}")
	private String url;

	@Value("#{jdbc.username}")
	private String username;

	@Value("#{jdbc.password}")
	private String password;

	@Test
	public void test() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println(connection);
		connection.close();
	}
}
