package Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataAccess {
    public Connection getConnection(){

        String driver = null;
        String url = null;
        String user = null;
        String password = null;
        Connection conn;

        Properties pro = new Properties();    //新建一个properties实例，用于从DBConfig中拿到连接参数。
        try {
            pro.load(this.getClass().getClassLoader().getResourceAsStream("dbConfig.properties")); //加载DBConfig文件。
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Class.forName(driver);   //加载jdbc驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            assert url != null;
            conn = DriverManager.getConnection(url,user,password);  //获取数据库连接
            conn.setAutoCommit(false);
            return conn;       //返回一个数据库连接。
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
