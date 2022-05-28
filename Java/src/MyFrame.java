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

        //�������
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        add(panel);

        //�����������
        comboBox.addItem("��һ�����");
        comboBox.addItem("�ڶ������");
        comboBox.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) panel.getLayout();
            int index = comboBox.getSelectedIndex();
            if(index == 0){
                cardLayout.show(panel, "��һ�����");
            }else if(index == 1) {
                cardLayout.show(panel, "�ڶ������");
            }
        });

        //��ӿ�Ƭ�е����
        panel1.add(new JButton("����"));
        panel1.add(new JButton("½ͨ��"));
        panel1.add(new JButton("����"));
        panel2.add(new JLabel("����"));
        panel2.add(new JTextField(16));

        //������
        contentPane.add(comboBox,BorderLayout.PAGE_START);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.add(panel1,"��һ�����");
        panel.add(panel2,"�ڶ������");

        //���ô��ڿɼ�
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame("����");
            }
        });
    }
}