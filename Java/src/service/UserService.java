package service;

import utils.JDBC;

import java.util.List;
import java.util.Map;

public class UserService {

    //��¼�ж��û����������Ƿ���ȷ
    public boolean loginCheck(String username , String password) {


        String sql = "SELECT * FROM user";
        List<Map<String, String>> list = JDBC.queryForListMap(sql);
        for (Map<String , String> map : list) {
            if(map.get("username").equals(username) && map.get("password").equals(password)) {
                return true;
            }
        }
        return false;
    }

    //ͨ���û����������ж��û�������
    public String getType(String username , String password) {
        String sql = "SELECT type FROM user WHERE username = '"+username+"' AND password = '"+password+"'";
        List<Map<String, String>> list = JDBC.queryForListMap(sql);
        return list.get(0).get("type");
    }

    public static void main(String[] args) {
        System.out.println(new UserService().getType("admin" , "456"));
    }

}
