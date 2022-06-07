package service;

import service.Impl.CourseService;
import dao.JDBC;

import java.util.List;
import java.util.Map;
import java.util.Vector;

public class CourseServiceImpl implements CourseService {

    public Vector<Vector<Object>> getAllCourse() {
        Vector<Vector<Object>> data = new Vector<>();
        List<Map<String, String>> list = JDBC.queryForListMap("SELECT student.stu_name ,course.* FROM student , course where student.id = course.stu_id");
        for (Map<String , String> map : list) {
            Vector<Object> vector = new Vector<>();
            vector.add(map.get("stu_id"));
            vector.add(map.get("stu_name"));
            vector.add(map.get("stu_name"));
            vector.add(map.get("math"));
            vector.add(map.get("chinese"));
            vector.add(map.get("english"));
            data.add(vector);
        }
        return data;
    }

}
