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
        jl1.setFont(new Font("΢���ź�", Font.PLAIN, 30));

        add(jl1);

        tabbedPane1 = new JTabbedPane();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        tabbedPane1.addTab("ѧ������" , studentPanel);
        tabbedPane1.addTab("ѧ���ɼ�����" , coursePanel);
        tabbedPane1.addTab("ע���˺Ų�ѯ(ֻ�й���Ա�ɼ�)" , adminPanel);

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
