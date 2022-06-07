package view.panels;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    JTextField text1;
    JPasswordField text2;
    JButton button;

    public LoginPanel() {

        setLayout(null);

        JLabel title = new JLabel("��ӭ����ѧ����Ϣ����ҳ��");
        text1 = new JTextField();
        text2 = new JPasswordField();
        JLabel area1 = new JLabel("����:");
        JLabel area2 = new JLabel("����:");
        button = new JButton("��¼");

        title.setBounds(90 , 20 , 500 , 100);
        title.setFont(new Font("΢���ź�", Font.PLAIN, 35));

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
