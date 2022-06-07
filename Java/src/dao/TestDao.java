package dao;

import java.util.List;
import java.util.Map;

public class TestDao {
    public static void main(String[] args) {
        List<Map<String, String>> list = JDBC.queryForListMap("SELECT * from user");
        System.out.println(list);
    }
}
