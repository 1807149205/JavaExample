package client.panels;

import javax.swing.*;
import java.awt.*;

public class IndexPanel extends JPanel {

    JLabel jl1;
    JTabbedPane tabbedPane1;
    StudentPanel studentPanel = new StudentPanel();
    TeacherPanel teacherPanel = new TeacherPanel();

    public IndexPanel() {

        setLayout(null);

//        JTextArea jTextArea = new JTextArea("我是IndexPanel页面");
//        jTextArea.setSize(100 , 50);

        jl1 = new JLabel();
        jl1.setBounds(40 , 0 , 800 , 80);
        jl1.setFont(new Font("微软雅黑", Font.PLAIN, 30));

        add(jl1);

        tabbedPane1 = new JTabbedPane();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        tabbedPane1.addTab("学生总览" , studentPanel);
        tabbedPane1.addTab("教师总览" , teacherPanel);

        add(tabbedPane1);
        tabbedPane1.setBounds(10 , 90 , 760 , 420);

    }

    public JLabel getJl1() {
        return jl1;
    }

    public JTabbedPane getTabbedPane1() {
        return tabbedPane1;
    }
}
