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
        ===================================主页面设计========================================
        ====================================================================================
         */

        super("学生信息管理系统");

        setSize(600 , 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        JMenuItem addStu = new JMenuItem("添加学生至远程数据库");
        JMenuItem search = new JMenuItem("模糊查找一位学生");
        JMenuItem deleteStu = new JMenuItem("删除一位学生");

        //将menuOpen.menuSave.menuSaveAs.menuClose菜单项加入到fileMenu菜单里面
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

        menuAbout.addActionListener(e -> {
            JOptionPane.showMessageDialog(null , "Java期末大作业\n作者:卫志龙\n主题:学生管理系统，角色管理");
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
                indexPanel.getJl1().setText("欢迎 " + username + type + " 登录学生管理系统");

                if(!type.equals("管理员")) {
                    indexPanel.getTabbedPane1().setEnabledAt(2 , false);
                    fileMenu.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(null , "登录失败，请检查用户名和密码");
            }
        });

    }

}
