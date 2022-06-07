package view.JFrames;

import pojo.User;
import service.Impl.UserServiceImpl;
import service.UserService;

import javax.swing.*;
import java.awt.*;

public class Register extends JFrame {

    public Register() {
        super("ע��");
        setSize(700 , 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(false);

        JLabel l1 = new JLabel("����:");
        l1.setBounds(170 , 30 , 50 , 50);
        l1.setFont(new Font("΢���ź�" , Font.PLAIN , 20));
        add(l1);

        JTextField username = new JTextField();
        username.setBounds(230 , 30 , 250, 50);
        username.setFont(new Font("΢���ź�" , Font.BOLD , 20));
        add(username);

        JLabel l2 = new JLabel("����:");
        l2.setBounds(170 , 100 , 50 , 50);
        l2.setFont(new Font("΢���ź�" , Font.PLAIN , 20));
        add(l2);

        JPasswordField password = new JPasswordField();
        password.setBounds(230 , 100 , 250, 50);
        password.setFont(new Font("΢���ź�" , Font.BOLD , 20));
        add(password);

        JLabel l3 = new JLabel("���ٴ���������:");
        l3.setForeground(new Color(250 , 0 , 0));
        l3.setBounds(70 , 160 , 160 , 50);
        l3.setFont(new Font("΢���ź�" , Font.PLAIN , 20));
        add(l3);

        JPasswordField rePassword = new JPasswordField();
        rePassword.setBounds(230 , 160 , 250, 50);
        rePassword.setFont(new Font("΢���ź�" , Font.BOLD , 20));
        add(rePassword);

        JLabel l4 = new JLabel("ѡ���˻�����:");
        l4.setBounds(200 , 250 , 100 , 50);
        add(l4);

        JComboBox<String> stringJComboBox = new JComboBox<>();
        stringJComboBox.addItem("����Ա");
        stringJComboBox.addItem("��ʦ");
        stringJComboBox.addItem("ѧ��");
        stringJComboBox.setBounds(300 ,250 , 150 , 50);
        add(stringJComboBox);

        JButton submit = new JButton("ע��");
        submit.setBounds(130 , 320 , 450 , 80);
        add(submit);

        submit.addActionListener(e -> {

            if(new String(password.getPassword()).equals(new String(rePassword.getPassword()))) {
                new UserServiceImpl().addUser(new User(
                        username.getText(),
                        new String(password.getPassword()),
                        (String) stringJComboBox.getSelectedItem()
                ));
                int i = JOptionPane.showConfirmDialog(null, "ע��ɹ��������ر�ע��ҳ��");
                if(i == 1) {
                    setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null , "�����������벻��ȷ������������");
            }


        });
    }

}
