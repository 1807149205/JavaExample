package service;

import java.util.Vector;

public interface UserService {

    //登录判断用户名和密码是否正确
    boolean loginCheck(String username , String password);

    //通过用户名和密码判断用户的属性
    String getType(String username , String password);

    //获取全部的用户信息
    Vector<Vector<Object>> getAllUser();

}
