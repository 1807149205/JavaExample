import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    JPanel panel1 = new JPanel(new FlowLayout());
    JPanel panel2 = new JPanel(new FlowLayout());
    JPanel panel = new JPanel(new CardLayout());
    JComboBox<String> comboBox = new JComboBox<>();

    public MyFrame(String title) throws HeadlessException {
        super(title);
        setBounds(100, 100, 500, 400);

        //内容面板
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        add(panel);

        //设置组件属性
        comboBox.addItem("第一个面板");
        comboBox.addItem("第二个面板");
        comboBox.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) panel.getLayout();
            int index = comboBox.getSelectedIndex();
            if(index == 0){
                cardLayout.show(panel, "第一个面板");
            }else if(index == 1) {
                cardLayout.show(panel, "第二个面板");
            }
        });

        //添加卡片中的组件
        panel1.add(new JButton("龙哲"));
        panel1.add(new JButton("陆通俊"));
        panel1.add(new JButton("韩冲"));
        panel2.add(new JLabel("输入"));
        panel2.add(new JTextField(16));

        //添加组件
        contentPane.add(comboBox,BorderLayout.PAGE_START);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.add(panel1,"第一个面板");
        panel.add(panel2,"第二个面板");

        //设置窗口可见
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame("测试");
            }
        });
    }
}