package com.gp.datasource;
/**
 * @author gp
 * @create 2019/12/21 23:20
 */
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.SQLException;

public class DBCP {
    public static DataSource getDataSource() {
        BasicDataSource dbcp = new BasicDataSource();
        dbcp.setDriverClassName("oracle.jdbc.OracleDriver");
        dbcp.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
        dbcp.setUsername("scott");
        dbcp.setPassword("tiger");
        dbcp.setInitialSize(20);//设置最大连接数
        dbcp.setMaxActive(10);//设置最大空闲数
        return dbcp;
    }

//	public static void main(String[] args) throws SQLException {
//		System.out.println(getDataSource());
//	}

}

