package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC {
    private static String url = "jdbc:mysql://124.221.227.243:3306/db1?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true"; //连接数据库(mysql是数据库名)
    private static String user = "root";//连接mysql的用户名
    private static String password = "wzlwzl";//连接mysql的密码
    private static Connection conn = null;

    /**
     * 获取一个数据库链接
     */
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    private static void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void execute(String sql) {
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            closeConn(conn);
        }
    }

    /**
     * 增加数据
     */
    public static void create(String sql) {
//        String sql = "INSERT INTO USER (user_name,user_password,user_age) VALUES('老王','123456',18)";
        execute(sql);
    }


    /**
     * 修改数据
     */
    public static void update(String sql) {
//        String sql = "UPDATE USER SET USER.user_name = '老李'";
        execute(sql);
    }

    private static ResultSet getResultSet(String sql) throws SQLException {
        PreparedStatement preparedStatement = null;
        //执行查询语句并返回结果集
        ResultSet resultSet;
        conn = getConnection();
        preparedStatement = conn.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public static List<Map<String, String>> queryForListMap(String sql) {
        ResultSet resultSet;
        List<Map<String, String>> result = new ArrayList<>();
        try {
            resultSet = getResultSet(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();//获得结果集结构信息,元数据
            int numberOfColumns = rsmd.getColumnCount();//获得列数
            while (resultSet.next()) {
                Map<String, String> rowData = new HashMap<>();
                for (int j = 1; j <= numberOfColumns; j++) {
                    rowData.put(rsmd.getColumnName(j), resultSet.getString(j));
                }
                result.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConn(conn);
        }
        return result;
    }
}
