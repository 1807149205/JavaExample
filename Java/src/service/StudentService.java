package service;

import pojo.Student;

import java.util.List;
import java.util.Vector;

public interface StudentService {

    //��ȡȫ����ѧ����Ϣ
    Vector<Vector<Object>> getAllStudent();

    //���һ��ѧ��
    void addStu(Student student);

    //ģ���������е�ѧ��
    List<Student> searchStu(String value);
}
