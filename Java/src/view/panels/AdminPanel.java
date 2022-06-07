package view.panels;

import service.Impl.UserServiceImpl;

import javax.swing.*;
import java.util.Vector;

public class AdminPanel extends JPanel {

    JTable table;
    Vector<Object> colName = new Vector<>();
    UserServiceImpl userServiceImpl = new UserServiceImpl();
    Vector<Vector<Object>> data = userServiceImpl.getAllUser();

    public AdminPanel() {
        colName.add("����");
        colName.add("����");
        colName.add("�û�����");

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
