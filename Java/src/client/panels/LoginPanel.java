package client.panels;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    public LoginPanel() {

        setLayout(null);

        JLabel title = new JLabel("欢迎来到学生信息管理页面");
        JTextField text1 = new JTextField();
        JPasswordField text2 = new JPasswordField();
        JLabel area1 = new JLabel("用户名");
        JLabel area2 = new JLabel("密码");
        JButton button = new JButton("登录");

        title.setBounds(100 , 20 , 500 , 100);
        title.setFont(new Font("微软雅黑", Font.PLAIN, 35));

        text1.setBounds(200 , 160 , 250 , 30);
        text2.setBounds(200 , 220 , 250 , 30);

        area1.setBounds(150 , 160 , 80 , 20);
        area2.setBounds(150 , 220 , 80 , 20);

        button.setBounds(160 , 300 , 300 , 60);

        add(text1);
        add(text2);
        add(area1);
        add(area2);
        add(button);
        add(title);

    }

}
