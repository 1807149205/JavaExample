package view.panels;

import service.Impl.CourseServiceImpl;
import service.CourseService;

import javax.swing.*;
import java.util.Vector;

public class CoursePanel extends JPanel {

    JTable table;
    Vector<Object> colName = new Vector<>();
    CourseService courseService = new CourseServiceImpl();
    Vector<Vector<Object>> data = courseService.getAllCourse();

    public CoursePanel() {

        colName.add("����");
        colName.add("ѧ��");
        colName.add("��ѧ�ɼ�");
        colName.add("���ĳɼ�");
        colName.add("Ӣ��ɼ�");

        table = new JTable(data , colName);
        table.setSize(400 , 400);
        add(new JScrollPane(table));

        JButton button = new JButton("�ֶ�ˢ�±��");
        button.setSize(150 , 50);
        add(button);
        button.addActionListener(e -> {
            flushTable();
        });
    }

    //ˢ��
    public void flushTable() {
        table.repaint();
        table.updateUI();
    }
}
