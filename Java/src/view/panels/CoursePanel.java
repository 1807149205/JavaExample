package view.panels;

import service.CourseServiceImpl;
import service.Impl.CourseService;

import javax.swing.*;
import java.util.Vector;

public class CoursePanel extends JPanel {

    JTable table;
    Vector<Object> colName = new Vector<>();
    CourseService courseService = new CourseServiceImpl();
    Vector<Vector<Object>> data = courseService.getAllCourse();

    public CoursePanel() {

        colName.add("姓名");
        colName.add("学号");
        colName.add("数学成绩");
        colName.add("语文成绩");
        colName.add("英语成绩");

        table = new JTable(data , colName);
        table.setSize(400 , 400);
        add(new JScrollPane(table));

        JButton button = new JButton("手动刷新表格");
        button.setSize(150 , 50);
        add(button);
        button.addActionListener(e -> {
            flushTable();
        });
    }

    //刷新
    public void flushTable() {
        table.repaint();
        table.updateUI();
    }
}
