package view.JFrames;

import pojo.Student;
import service.Impl.StudentServiceImpl;

import javax.swing.*;

public class AddStudent extends JFrame {

    StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

    public AddStudent() {
        setSize(300 , 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        JLabel jl1 = new JLabel("学号");
        jl1.setBounds(5 , 5 , 50 , 50);

        JTextField jt1 = new JTextField();
        jt1.setBounds(80 , 10 , 150 , 30);

        JLabel jl2 = new JLabel("姓名");
        jl2.setBounds(5 , 55 , 50 , 50);

        JTextField jt2 = new JTextField();
        jt2.setBounds(80 , 60 , 150 , 30);

        JLabel jl3 = new JLabel("性别");
        jl3.setBounds(5 , 110 , 50 , 50);

        JTextField jt3 = new JTextField();
        jt3.setBounds(80 , 115 , 150 , 30);

        JLabel jl4 = new JLabel("出生日期");
        jl4.setBounds(5 , 155 , 50 , 50);

        JTextField jt4 = new JTextField();
        jt4.setBounds(80 , 160 , 150 , 30);

        JLabel jl5 = new JLabel("所在系");
        jl5.setBounds(5 , 205 , 50 , 50);

        JTextField jt5 = new JTextField();
        jt5.setBounds(80 , 210 , 150 , 30);

        JButton button = new JButton("添加");
        button.setBounds(50 , 280 , 180 , 60);

        add(jl1);
        add(jt1);
        add(jl2);
        add(jt2);
        add(jl3);
        add(jt3);
        add(jt4);
        add(jl4);
        add(jt4);
        add(jl5);
        add(jt5);

        add(button);

        button.addActionListener(e -> {
            if(jt1.getText().equals("")) {
                JOptionPane.showMessageDialog(null , "请输入内容");
            } else {
                Student student = new Student(
                        Integer.parseInt(jt1.getText()),
                        jt2.getText(),
                        jt3.getText(),
                        jt4.getText(),
                        jt5.getText()
                );
                studentServiceImpl.addStu(student);
                JOptionPane.showMessageDialog(null , "添加成功");
                setVisible(false);
                jt1.setText("");
                jt2.setText("");
                jt3.setText("");
                jt4.setText("");
                jt5.setText("");
            }


        });

        setVisible(false);
    }

}
