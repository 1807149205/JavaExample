package view.JFrames;

import javax.swing.*;

public class DeleteStudent extends JFrame {

    public DeleteStudent() {

        setSize(300 , 250);
        setVisible(false);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JLabel j1 = new JLabel("«Î ‰»Î—ß∫≈:");
        j1.setBounds(10 , 10 , 80 , 30);
        add(j1);

        JTextField field1 = new JTextField();
        field1.setBounds(100 , 10 , 100 , 30);
        add(field1);

        JButton button = new JButton("…æ≥˝");
        button.setBounds(10 , 80 , 250 , 50);
        add(button);
    }


    public static void main(String[] args) {
        new DeleteStudent();
    }

}
