package view.panels;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    JTextField text1;
    JPasswordField text2;
    JButton button;

    public LoginPanel() {

        setLayout(null);

        JLabel title = new JLabel("欢迎来到学生信息管理页面");
        text1 = new JTextField();
        text2 = new JPasswordField();
        JLabel area1 = new JLabel("姓名:");
        JLabel area2 = new JLabel("密码:");
        button = new JButton("登录");

        title.setBounds(90 , 20 , 500 , 100);
        title.setFont(new Font("微软雅黑", Font.PLAIN, 35));

        text1.setBounds(190 , 160 , 250 , 30);
        text2.setBounds(190 , 220 , 250 , 30);

        area1.setBounds(140 , 160 , 80 , 20);
        area2.setBounds(140 , 220 , 80 , 20);

        button.setBounds(150 , 300 , 300 , 60);

        add(text1);
        add(text2);
        add(area1);
        add(area2);
        add(button);
        add(title);
    }

    public JTextField getText1() {
        return text1;
    }

    public JPasswordField getText2() {
        return text2;
    }

    public JButton getButton() {
        return button;
    }
}
