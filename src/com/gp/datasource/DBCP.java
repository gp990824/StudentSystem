package com.gp.datasource;
/**
 * @author gp
 * @create 2019/12/21 23:20
 */

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBCP {
    private static BasicDataSource dbcp;

    static {
        dbcp = new BasicDataSource();
        dbcp.setDriverClassName("oracle.jdbc.OracleDriver");
        dbcp.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
        dbcp.setUsername("scott");
        dbcp.setPassword("tiger");
        dbcp.setInitialSize(20);//设置最大连接数
        dbcp.setMaxActive(10);//设置最大空闲数
    }

    public static Connection getConnection() throws SQLException {
        return dbcp.getConnection();
    }

}

