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
        colName.add("姓名");
        colName.add("密码");
        colName.add("用户类型");

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
