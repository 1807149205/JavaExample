package client.panels;

import javax.swing.*;

public class IndexPanel extends JPanel {

    public IndexPanel() {

        JTextArea jTextArea = new JTextArea("我是IndexPanel页面");
        jTextArea.setSize(100 , 50);

        this.add(jTextArea);

    }

}
