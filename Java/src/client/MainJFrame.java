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
        ===================================主页面设计========================================
        ====================================================================================
         */

        super("学生信息管理系统");

        setSize(600 , 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);

        cardLayout = new CardLayout();

        setLayout(cardLayout);
        add(loginPanel , "login");
        add(indexPanel , "index");

        JButton button = new JButton("确认");
        button.setBounds(50 , 60 , 90 , 20);
        add(button);

        /*
        ====================================================================================
        ===================================菜单栏部分========================================
        ====================================================================================
         */

        JMenu fileMenu = new JMenu("菜单");
        JMenu editMenu = new JMenu("编辑");
        JMenu aboutMenu = new JMenu("关于");

        //设置菜单项
        JMenuItem menuOpen = new JMenuItem("打开文件");
        JMenuItem menuSave = new JMenuItem("保存文件");
        JMenuItem menuSaveAs = new JMenuItem("文件另存为");
        JMenuItem menuClose = new JMenuItem("关闭");

        //将menuOpen.menuSave.menuSaveAs.menuClose菜单项加入到fileMenu菜单里面
        fileMenu.add(menuOpen);
        fileMenu.add(menuSave);
        fileMenu.add(menuSaveAs);
        fileMenu.add(menuClose);

        JMenuItem menuCut = new JMenuItem("剪切");
        JMenuItem menuCopy = new JMenuItem("复制");
        JMenuItem menuPaste = new JMenuItem("粘贴");

        editMenu.add(menuCut);
        editMenu.add(menuCopy);
        editMenu.add(menuPaste);

        JMenuItem menuAbout = new JMenuItem("关于本软件");

        aboutMenu.add(menuAbout);

        //创建菜单栏对象
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);

        //将menuBar设置在窗口上面
        setJMenuBar(menuBar);

        /*
        ====================================================================================
        ================================菜单栏的单击事件=====================================
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
