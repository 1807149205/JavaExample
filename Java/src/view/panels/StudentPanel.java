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
        colName.add("ѧ��");
        colName.add("����");
        colName.add("�Ա�");
        colName.add("����");
        colName.add("����ϵ");

        table = new JTable(data , colName);
        table.setSize(400 , 400);
        add(new JScrollPane(table));

        JButton button = new JButton("�ֶ�ˢ�±��");
        button.setSize(150 , 50);
        add(button);
        button.addActionListener(e -> flushTable());
    }

    //ˢ��
    public void flushTable() {
        if(data.size() != studentServiceImpl.getAllStudent().size()) {
            data.add(studentServiceImpl.getAllStudent().get(studentServiceImpl.getAllStudent().size() - 1));
        }
        System.out.println(data);
        table.repaint();
        table.updateUI();
    }

}
