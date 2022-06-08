package service;

import pojo.Student;

import java.util.List;
import java.util.Vector;

public interface StudentService {

    //获取全部的学生信息
    Vector<Vector<Object>> getAllStudent();

    //添加一个学生
    void addStu(Student student);

    //模糊查找所有的学生
    List<Student> searchStu(String value);

    String getAllStudentString();

    void updateStudent(int id , String type , String value);
}
