package view.panels;


import javax.swing.*;
import java.awt.*;

public class IndexPanel extends JPanel {

    JLabel jl1;
    JTabbedPane tabbedPane1;
    StudentPanel studentPanel = new StudentPanel();
    AdminPanel adminPanel = new AdminPanel();
    CoursePanel coursePanel = new CoursePanel();

    public IndexPanel() {

        setLayout(null);

        jl1 = new JLabel();
        jl1.setBounds(40 , 0 , 800 , 80);
        jl1.setFont(new Font("微软雅黑", Font.PLAIN, 30));

        add(jl1);

        tabbedPane1 = new JTabbedPane();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        tabbedPane1.addTab("学生总览" , studentPanel);
        tabbedPane1.addTab("学生成绩总览" , coursePanel);
        tabbedPane1.addTab("注册账号查询(只管理员课间)" , adminPanel);

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
