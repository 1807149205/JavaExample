package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC {
    private static String url = "jdbc:mysql://124.221.227.243:3306/db1?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true"; //�������ݿ�(mysql�����ݿ���)
    private static String user = "root";//����mysql���û���
    private static String password = "wzlwzl";//����mysql������
    private static Connection conn = null;

    /**
     * ��ȡһ�����ݿ�����
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
     * ��������
     */
    public static void create(String sql) {
//        String sql = "INSERT INTO USER (user_name,user_password,user_age) VALUES('����','123456',18)";
        execute(sql);
    }


    /**
     * �޸�����
     */
    public static void update(String sql) {
//        String sql = "UPDATE USER SET USER.user_name = '����'";
        execute(sql);
    }

    private static ResultSet getResultSet(String sql) throws SQLException {
        PreparedStatement preparedStatement = null;
        //ִ�в�ѯ��䲢���ؽ����
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
            ResultSetMetaData rsmd = resultSet.getMetaData();//��ý�����ṹ��Ϣ,Ԫ����
            int numberOfColumns = rsmd.getColumnCount();//�������
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
