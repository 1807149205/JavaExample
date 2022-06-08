package service.Impl;

import pojo.Student;
import service.StudentService;
import dao.JDBC;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class StudentServiceImpl implements StudentService {

    @Override
    public Vector<Vector<Object>> getAllStudent() {
        Vector<Vector<Object>> data = new Vector<>();
        List<Map<String, String>> list = JDBC.queryForListMap("SELECT * FROM student");
        for (Map<String , String> map : list) {
            Vector<Object> vector = new Vector<>();
            vector.add(map.get("id"));
            vector.add(map.get("stu_name"));
            vector.add(map.get("stu_sex"));
            vector.add(map.get("stu_birthday"));
            vector.add(map.get("stu_dept"));
            data.add(vector);
        }
        return data;
    }

    @Override
    public void addStu(Student student) {
        String sql = "INSERT INTO student VALUES('"+student.getId()+"' , '"+student.getStuName()+"' , '"+student.getStuSex()+"' , '"+student.getStuBirthday()+"' , '"+student.getStuDept()+"')";
        JDBC.create(sql);
    }

    @Override
    public List<Student> searchStu(String value) {
        String sql = "SELECT * FROM student WHERE stu_name like '"+value+"%'";
        List<Map<String, String>> list = JDBC.queryForListMap(sql);
        List<Student> students = new ArrayList<>();
        for (Map<String , String> map : list) {
            students.add(new Student(
                    Integer.parseInt(map.get("id")),
                    map.get("stu_name"),
                    map.get("stu_sex"),
                    map.get("stu_birthday"),
                    map.get("stu_dept")
            ));
        }
        return students;
    }

    @Override
    public String getAllStudentString() {
        StringBuilder sb = new StringBuilder();
        Vector<Vector<Object>> allStudent = this.getAllStudent();
        sb.append("学号\t\t姓名\t\t性别\t\t出生年月\t\t所在系\r\n");
        for (Vector<Object> obj : allStudent) {
            for (Object o : obj) {
                sb.append(o).append("\t\t");
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }

    @Override
    public void updateStudent(int id , String type , String value) {
        try {
            String sql = "";
            if(type.equals("出生日期")) {
                sql = "UPDATE student SET stu_birthday = '"+value+"' WHERE id = '"+id+"'";
            } else if(type.equals("系")) {
                sql = "UPDATE student SET stu_dept = '"+value+"' WHERE id = '"+id+"'";
            }
            JDBC.update(sql);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
