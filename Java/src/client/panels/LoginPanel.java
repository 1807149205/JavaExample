package client.panels;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    public LoginPanel() {

        setLayout(null);

        JLabel title = new JLabel("��ӭ����ѧ����Ϣ����ҳ��");
        JTextField text1 = new JTextField();
        JPasswordField text2 = new JPasswordField();
        JLabel area1 = new JLabel("�û���");
        JLabel area2 = new JLabel("����");
        JButton button = new JButton("��¼");

        title.setBounds(100 , 20 , 500 , 100);
        title.setFont(new Font("΢���ź�", Font.PLAIN, 35));

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
