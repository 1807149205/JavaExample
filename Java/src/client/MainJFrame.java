package client;

import client.panels.IndexPanel;
import client.panels.LoginPanel;
import service.UserService;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame {

    CardLayout cardLayout;
    LoginPanel loginPanel = new LoginPanel();
    IndexPanel indexPanel = new IndexPanel();
    UserService userService = new UserService();

    public MainJFrame() {

        /*
        ====================================================================================
        ===================================��ҳ�����========================================
        ====================================================================================
         */

        super("ѧ����Ϣ����ϵͳ");

        setSize(600 , 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
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
        JMenuItem selectAll = new JMenuItem("��ѯѧ����ȫ����Ϣ");
        JMenuItem addStu = new JMenuItem("���ѧ����Զ�����ݿ�");
        JMenuItem search = new JMenuItem("ģ������һλѧ��");
        JMenuItem deleteStu = new JMenuItem("ɾ��һλѧ��");

        //��menuOpen.menuSave.menuSaveAs.menuClose�˵�����뵽fileMenu�˵�����
        fileMenu.add(selectAll);
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

//        menuOpen.addActionListener(e -> {
//            cardLayout.show(this.getContentPane() , "login");
//        });
//
//        menuSave.addActionListener(e -> {
//            cardLayout.show(this.getContentPane() , "index");
//        });


        loginPanel.getButton().addActionListener(e -> {
            String username = loginPanel.getText1().getText();
            String password = new String(loginPanel.getText2().getPassword());

            if(userService.loginCheck(username , password)) {
                cardLayout.show(this.getContentPane() , "index");
                this.setSize(800 , 600);
                setLocationRelativeTo(null);
                menuBar.setVisible(true);

                String type = userService.getType(username , password);
                indexPanel.getJl1().setText("��ӭ " + username + type + " ��¼�����¼ϵͳ");

                if(!type.equals("����Ա")) {
                    indexPanel.getTabbedPane1().setEnabledAt(1 , false);
                }
            } else {
                JOptionPane.showMessageDialog(null , "��¼ʧ�ܣ������û���������");
            }
        });

    }

}
