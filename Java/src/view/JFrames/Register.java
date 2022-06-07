package view.JFrames;

import pojo.User;
import service.Impl.UserServiceImpl;
import service.UserService;

import javax.swing.*;
import java.awt.*;

public class Register extends JFrame {

    public Register() {
        super("注册");
        setSize(700 , 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(false);

        JLabel l1 = new JLabel("姓名:");
        l1.setBounds(170 , 30 , 50 , 50);
        l1.setFont(new Font("微软雅黑" , Font.PLAIN , 20));
        add(l1);

        JTextField username = new JTextField();
        username.setBounds(230 , 30 , 250, 50);
        username.setFont(new Font("微软雅黑" , Font.BOLD , 20));
        add(username);

        JLabel l2 = new JLabel("密码:");
        l2.setBounds(170 , 100 , 50 , 50);
        l2.setFont(new Font("微软雅黑" , Font.PLAIN , 20));
        add(l2);

        JPasswordField password = new JPasswordField();
        password.setBounds(230 , 100 , 250, 50);
        password.setFont(new Font("微软雅黑" , Font.BOLD , 20));
        add(password);

        JLabel l3 = new JLabel("请再次输入密码:");
        l3.setForeground(new Color(250 , 0 , 0));
        l3.setBounds(70 , 160 , 160 , 50);
        l3.setFont(new Font("微软雅黑" , Font.PLAIN , 20));
        add(l3);

        JPasswordField rePassword = new JPasswordField();
        rePassword.setBounds(230 , 160 , 250, 50);
        rePassword.setFont(new Font("微软雅黑" , Font.BOLD , 20));
        add(rePassword);

        JLabel l4 = new JLabel("选择账户类型:");
        l4.setBounds(200 , 250 , 100 , 50);
        add(l4);

        JComboBox<String> stringJComboBox = new JComboBox<>();
        stringJComboBox.addItem("管理员");
        stringJComboBox.addItem("教师");
        stringJComboBox.addItem("学生");
        stringJComboBox.setBounds(300 ,250 , 150 , 50);
        add(stringJComboBox);

        JButton submit = new JButton("注册");
        submit.setBounds(130 , 320 , 450 , 80);
        add(submit);

        submit.addActionListener(e -> {

            if(new String(password.getPassword()).equals(new String(rePassword.getPassword()))) {
                new UserServiceImpl().addUser(new User(
                        username.getText(),
                        new String(password.getPassword()),
                        (String) stringJComboBox.getSelectedItem()
                ));
                int i = JOptionPane.showConfirmDialog(null, "注册成功，即将关闭注册页面");
                if(i == 1) {
                    setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null , "两次输入密码不正确，请重新输入");
            }


        });
    }

}
