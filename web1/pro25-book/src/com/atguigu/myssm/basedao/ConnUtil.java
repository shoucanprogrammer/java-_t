package com.atguigu.myssm.basedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnUtil {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver" ;
    public static final String URL = "jdbc:mysql://localhost:3306/bookdb";
    public static final String USER = "root";
    public static final String PWD = "123456" ;

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
    public static Connection creatConn(){
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.通过驱动管理器获取连接对象
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//    @Test
//    public void test(){
//        Connection conn = getConn();
//        System.out.println();
//    }
    public static Connection getConn(){
        Connection conn = threadLocal.get();
        if (conn == null){
            conn = creatConn();
            threadLocal.set(conn);
        }
        return threadLocal.get();
    }

    public static void closeConn() throws SQLException {
        Connection conn = threadLocal.get();
        if (conn==null){
            return;
        }
        if (!conn.isClosed()){
            conn.close();
            threadLocal.set(null);
        }
    }
}
