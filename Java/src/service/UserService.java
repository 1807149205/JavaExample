package service;

import java.util.Vector;

public interface UserService {

    //��¼�ж��û����������Ƿ���ȷ
    boolean loginCheck(String username , String password);

    //ͨ���û����������ж��û�������
    String getType(String username , String password);

    //��ȡȫ�����û���Ϣ
    Vector<Vector<Object>> getAllUser();

}
