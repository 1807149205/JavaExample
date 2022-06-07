package service.Impl;

import pojo.User;
import service.UserService;
import dao.JDBC;

import java.util.List;
import java.util.Map;
import java.util.Vector;

public class UserServiceImpl implements UserService {


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


    public String getType(String username , String password) {
        String sql = "SELECT type FROM user WHERE username = '"+username+"' AND password = '"+password+"'";
        List<Map<String, String>> list = JDBC.queryForListMap(sql);
        return list.get(0).get("type");
    }

    public Vector<Vector<Object>> getAllUser() {
        Vector<Vector<Object>> data = new Vector<>();
        List<Map<String, String>> list = JDBC.queryForListMap("SELECT * FROM user");
        for (Map<String , String> map : list) {
            Vector<Object> vector = new Vector<>();
            vector.add(map.get("username"));
            vector.add(map.get("password"));
            vector.add(map.get("type"));
            data.add(vector);
        }
        return data;
    }

    public void addUser(User user) {
        String sql = "INSERT INTO user (username , password , type) VALUES ('"+user.getUsername()+"' , '"+user.getPassword()+"' , '"+user.getType()+"')";
        System.out.println(sql);
        JDBC.create(sql);
    }

}
