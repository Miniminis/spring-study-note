package com.firstboot;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstBootApplicationTests {

	@Autowired
	private DataSource datasource;
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	@Test
	public void contextLoads() {
	}

	@Test
	public void connectionTest() throws SQLException {
		System.out.println("datasource test : " + datasource);
		Connection conn = datasource.getConnection();
		System.out.println("conn test : " + conn);
		conn.close();

		// 출력결과
		// datasource test : HikariDataSource (HikariPool-1)
		// conn test : HikariProxyConnection@482104979 wrapping
		// com.mysql.cj.jdbc.ConnectionImpl@3d2f3dcb

	}

	@Test
	public void testSqlSessionFactory() {
		System.out.println("sessionFactory TEST :: "+sessionFactory);
	}
}
