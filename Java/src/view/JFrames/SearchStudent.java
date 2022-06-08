package view.JFrames;

import pojo.Student;
import service.Impl.StudentServiceImpl;

import javax.swing.*;
import java.util.List;

public class SearchStudent extends JFrame {

    public SearchStudent() {
        super("ģ������ѧ��");

        setLayout(null);
        setSize(400 , 500);
        setVisible(false);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel l1 = new JLabel("����������:");
        l1.setBounds(20 , 30 , 100 , 30);
        JTextField jt1 = new JTextField();
        jt1.setBounds(100 , 30 , 180 , 40);

        JButton button = new JButton("ȷ��");
        button.setBounds(50 , 100 , 300 , 50);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(10 , 200 , 360 , 280);
        textArea.setLineWrap(true);

        button.addActionListener(e -> {
            textArea.setText("");
            List<Student> students = new StudentServiceImpl().searchStu(jt1.getText());
            if(students.size() != 0) {
                System.out.println(students);
                StringBuilder sb = new StringBuilder();
                for (Student student : students) {
                    sb.append(student.toString()).append("\n\n");
                }
                textArea.setText(sb.toString());
            } else {
                JOptionPane.showMessageDialog(null , "��ѯ���Ϊ��");
            }

        });

        add(l1);
        add(jt1);
        add(button);
        add(textArea);

    }

}
