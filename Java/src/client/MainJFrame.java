package client;

import client.panels.IndexPanel;
import client.panels.LoginPanel;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame {

    CardLayout cardLayout;
    LoginPanel loginPanel = new LoginPanel();
    IndexPanel indexPanel = new IndexPanel();

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
        setResizable(true);
        setVisible(true);

        cardLayout = new CardLayout();

        setLayout(cardLayout);
        add(loginPanel , "login");
        add(indexPanel , "index");

        JButton button = new JButton("ȷ��");
        button.setBounds(50 , 60 , 90 , 20);
        add(button);

        /*
        ====================================================================================
        ===================================�˵�������========================================
        ====================================================================================
         */

        JMenu fileMenu = new JMenu("�˵�");
        JMenu editMenu = new JMenu("�༭");
        JMenu aboutMenu = new JMenu("����");

        //���ò˵���
        JMenuItem menuOpen = new JMenuItem("���ļ�");
        JMenuItem menuSave = new JMenuItem("�����ļ�");
        JMenuItem menuSaveAs = new JMenuItem("�ļ����Ϊ");
        JMenuItem menuClose = new JMenuItem("�ر�");

        //��menuOpen.menuSave.menuSaveAs.menuClose�˵�����뵽fileMenu�˵�����
        fileMenu.add(menuOpen);
        fileMenu.add(menuSave);
        fileMenu.add(menuSaveAs);
        fileMenu.add(menuClose);

        JMenuItem menuCut = new JMenuItem("����");
        JMenuItem menuCopy = new JMenuItem("����");
        JMenuItem menuPaste = new JMenuItem("ճ��");

        editMenu.add(menuCut);
        editMenu.add(menuCopy);
        editMenu.add(menuPaste);

        JMenuItem menuAbout = new JMenuItem("���ڱ����");

        aboutMenu.add(menuAbout);

        //�����˵�������
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);

        //��menuBar�����ڴ�������
        setJMenuBar(menuBar);

        /*
        ====================================================================================
        ================================�˵����ĵ����¼�=====================================
        ====================================================================================
         */

        menuOpen.addActionListener(e -> {
            cardLayout.show(this.getContentPane() , "login");
        });

        menuSave.addActionListener(e -> {
            cardLayout.show(this.getContentPane() , "index");
        });
    }

}
