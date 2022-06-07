package view.panels;

import view.JFrames.Register;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    JTextField text1;
    JPasswordField text2;
    JButton button;

    Register register;

    public LoginPanel() {

        setLayout(null);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                register = new Register();
            }
        });

        JLabel title = new JLabel("Ñ§ÉúÐÅÏ¢¹ÜÀíµÇÂ¼Ò³Ãæ");
        text1 = new JTextField();
        text2 = new JPasswordField();
        JLabel area1 = new JLabel("ÐÕÃû:");
        JLabel area2 = new JLabel("ÃÜÂë:");
        area1.setFont(new Font("Î¢ÈíÑÅºÚ" , Font.PLAIN , 18));
        area2.setFont(new Font("Î¢ÈíÑÅºÚ" , Font.PLAIN , 18));

        button = new JButton("µÇÂ¼");

        title.setBounds(110 , 20 , 500 , 100);
        title.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 35));

        text1.setBounds(190 , 150 , 250 , 50);
        text2.setBounds(190 , 210 , 250 , 50);

        area1.setBounds(140 , 160 , 80 , 20);
        area2.setBounds(140 , 220 , 80 , 20);

        button.setBounds(150 , 300 , 300 , 60);

        JButton reg = new JButton("»¹Ã»ÕËºÅ£¿µãÎÒ×¢²áÒ»¸ö");
        reg.setBounds(400 , 400 , 180 , 30);

        add(text1);
        add(text2);
        add(area1);
        add(area2);
        add(button);
        add(title);
        add(reg);




        reg.addActionListener(e -> {
            register.setVisible(true);
        });
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
