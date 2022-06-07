package view.panels;

import service.Impl.StudentServiceImpl;

import javax.swing.*;
import java.util.Vector;

public class StudentPanel extends JPanel {

    JTable table;
    Vector<Object> colName = new Vector<>();
    StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
    Vector<Vector<Object>> data = studentServiceImpl.getAllStudent();

    public StudentPanel() {
        colName.add("学号");
        colName.add("姓名");
        colName.add("性别");
        colName.add("生日");
        colName.add("所在系");

        table = new JTable(data , colName);
        add(new JScrollPane(table));

        JButton button = new JButton("手动刷新表格");
        button.setSize(150 , 50);
        add(button);
        button.addActionListener(e -> flushTable());
    }

    //刷新
    public void flushTable() {
        //增加
        if(data.size() < studentServiceImpl.getAllStudent().size()) {
            data.add(studentServiceImpl.getAllStudent().get(studentServiceImpl.getAllStudent().size() - 1));
        }
        //减少
        if(data.size() < studentServiceImpl.getAllStudent().size()) {
            Vector<Vector<Object>> allStudent = studentServiceImpl.getAllStudent();
            for (Vector<Object> objects : allStudent) {
                if(!data.contains(objects)) {
                    data.remove(objects);
                }
            }
        }
        table.repaint();
        table.updateUI();
    }

}
