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
        ===================================主页面设计========================================
        ====================================================================================
         */

        super("学生信息管理系统");

        setSize(600 , 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        cardLayout = new CardLayout();

        setLayout(cardLayout);
        //往卡片中添加内容
        add(loginPanel , "login");
        add(indexPanel , "index");

        /*
        ====================================================================================
        ===================================菜单栏部分========================================
        ====================================================================================
         */

        JMenu fileMenu = new JMenu("菜单");
        JMenu editMenu = new JMenu("文件");
        JMenu aboutMenu = new JMenu("关于");

        //设置菜单项
        JMenuItem selectAll = new JMenuItem("查询学生的全部信息");
        JMenuItem addStu = new JMenuItem("添加学生至远程数据库");
        JMenuItem search = new JMenuItem("模糊查找一位学生");
        JMenuItem deleteStu = new JMenuItem("删除一位学生");

        //将menuOpen.menuSave.menuSaveAs.menuClose菜单项加入到fileMenu菜单里面
        fileMenu.add(selectAll);
        fileMenu.add(addStu);
        fileMenu.add(search);
        fileMenu.add(deleteStu);

        JMenuItem getFile = new JMenuItem("将学生信息输出到本地文件中");

        editMenu.add(getFile);

        JMenuItem menuAbout = new JMenuItem("关于本软件");

        aboutMenu.add(menuAbout);

        //创建菜单栏对象
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(aboutMenu);

        //将menuBar设置在窗口上面
        setJMenuBar(menuBar);

        menuBar.setVisible(false);

        /*
        ====================================================================================
        ================================菜单栏的单击事件=====================================
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
                indexPanel.getJl1().setText("欢迎 " + username + type + " 登录管理登录系统");

                if(!type.equals("管理员")) {
                    indexPanel.getTabbedPane1().setEnabledAt(1 , false);
                }
            } else {
                JOptionPane.showMessageDialog(null , "登录失败，请检查用户名和密码");
            }
        });

    }

}
