package view;

import view.JFrames.AddStudent;
import view.JFrames.DeleteStudent;
import view.JFrames.SearchStudent;
import view.panels.IndexPanel;
import view.panels.LoginPanel;
import service.Impl.UserServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainJFrame extends JFrame {

    CardLayout cardLayout;
    JFileChooser jFileChooser;
    LoginPanel loginPanel = new LoginPanel();
    IndexPanel indexPanel = new IndexPanel();
    UserServiceImpl userServiceImpl = new UserServiceImpl();
    AddStudent addStudent = new AddStudent();
    SearchStudent searchStudent = new SearchStudent();
    DeleteStudent deleteStudent = new DeleteStudent();

    public MainJFrame() {

        /*
        ====================================================================================
        ===================================��ҳ�����========================================
        ====================================================================================
         */

        super("ѧ����Ϣ����ϵͳ");

        setSize(600 , 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        cardLayout = new CardLayout();

        setLayout(cardLayout);
        //����Ƭ���������
        add(loginPanel , "login");
        add(indexPanel , "index");

        /*
        ====================================================================================
        ===================================�˵�������========================================
        ====================================================================================
         */

        JMenu fileMenu = new JMenu("�˵�");
        JMenu editMenu = new JMenu("�ļ�");
        JMenu aboutMenu = new JMenu("����");

        //���ò˵���
        JMenuItem addStu = new JMenuItem("���ѧ����Զ�����ݿ�");
        JMenuItem search = new JMenuItem("ģ������һλѧ��");
        JMenuItem deleteStu = new JMenuItem("ɾ��һλѧ��");

        //��menuOpen.menuSave.menuSaveAs.menuClose�˵�����뵽fileMenu�˵�����
        fileMenu.add(addStu);
        fileMenu.add(search);
        fileMenu.add(deleteStu);

        JMenuItem getFile = new JMenuItem("��ѧ����Ϣ����������ļ���");

        editMenu.add(getFile);

        JMenuItem menuAbout = new JMenuItem("���ڱ����");

        aboutMenu.add(menuAbout);

        //�����˵�������
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);

        //��menuBar�����ڴ�������
        setJMenuBar(menuBar);

        menuBar.setVisible(false);

        /*
        ====================================================================================
        ================================�˵����ĵ����¼�=====================================
        ====================================================================================
         */

        menuAbout.addActionListener(e -> {
            JOptionPane.showMessageDialog(null , "Java��ĩ����ҵ\n����:��־��\n����:ѧ������ϵͳ����ɫ����");
        });

        addStu.addActionListener(e -> {
            addStudent.setVisible(true);
        });

        search.addActionListener(e -> {
            searchStudent.setVisible(true);
        });
        deleteStu.addActionListener(e -> {
            deleteStudent.setVisible(true);
        });
        getFile.addActionListener(e -> {
            jFileChooser = new JFileChooser(".");
            jFileChooser.showSaveDialog(this);
            File file = jFileChooser.getSelectedFile();

        });


        loginPanel.getButton().addActionListener(e -> {
            String username = loginPanel.getText1().getText();
            String password = new String(loginPanel.getText2().getPassword());

            if(userServiceImpl.loginCheck(username , password)) {
                cardLayout.show(this.getContentPane() , "index");
                this.setSize(800 , 600);
                setLocationRelativeTo(null);
                menuBar.setVisible(true);

                String type = userServiceImpl.getType(username , password);
                indexPanel.getJl1().setText("��ӭ " + username + type + " ��¼ѧ������ϵͳ");

                if(!type.equals("����Ա")) {
                    indexPanel.getTabbedPane1().setEnabledAt(2 , false);
                    fileMenu.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(null , "��¼ʧ�ܣ������û���������");
            }
        });

    }

}
