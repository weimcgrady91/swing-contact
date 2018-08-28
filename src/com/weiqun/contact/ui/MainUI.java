package com.weiqun.contact.ui;

import com.weiqun.contact.util.LocationUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainUI extends JFrame implements ActionListener {
    private final static int WIDTH = 600;
    private final static int HEIGHT = 450;
    private JPanel contentPanel;
    private final JMenuItem jMenuItem1;
    private final JMenuItem jMenuItem2;
    private final JMenuItem jMenuItem3;
    private final JMenuItem jMenuItem10;

    public MainUI() {
        setTitle("通讯管理系统");
        setSize(WIDTH, HEIGHT);
        LocationUtils.setLocation(this, WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        JMenuBar menuBar1 = new JMenuBar();
        setJMenuBar(menuBar1);
        JMenu menu1 = new JMenu("同学通讯系统");
        JMenu menu2 = new JMenu("同事通讯系统");
        JMenu menu3 = new JMenu("朋友通讯系统");
        JMenu menu4 = new JMenu("查询系统");
        JMenu menu5 = new JMenu("帮助系统");
        menuBar1.add(menu1);
        menuBar1.add(menu2);
        menuBar1.add(menu3);
        menuBar1.add(menu4);
        menuBar1.add(menu5);

        jMenuItem1 = new JMenuItem("同学基本信息系统");
        jMenuItem1.addActionListener(this);
        jMenuItem2 = new JMenuItem("同学联系方式系统");
        jMenuItem2.addActionListener(this);
        jMenuItem3 = new JMenuItem("新增同学");
        jMenuItem3.addActionListener(this);

        menu1.add(jMenuItem1);
        menu1.add(jMenuItem2);
        menu1.add(jMenuItem3);

        JMenuItem jMenuItem4 = new JMenuItem("同事基本信息系统");
        JMenuItem jMenuItem5 = new JMenuItem("同事联系方式系统");
        JMenuItem jMenuItem6 = new JMenuItem("新增同事");
        menu2.add(jMenuItem4);
        menu2.add(jMenuItem5);
        menu2.add(jMenuItem6);

        JMenuItem jMenuItem7 = new JMenuItem("朋友基本信息系统");
        JMenuItem jMenuItem8 = new JMenuItem("朋友联系方式系统");
        JMenuItem jMenuItem9 = new JMenuItem("新增朋友");
        menu3.add(jMenuItem7);
        menu3.add(jMenuItem8);
        menu3.add(jMenuItem9);

        jMenuItem10 = new JMenuItem("同学查询系统");
        jMenuItem10.addActionListener(this);
        JMenuItem jMenuItem11 = new JMenuItem("同事查询系统");
        JMenuItem jMenuItem12 = new JMenuItem("朋友查询查询");
        menu4.add(jMenuItem10);
        menu4.add(jMenuItem11);
        menu4.add(jMenuItem12);

        JMenuItem jMenuItem13 = new JMenuItem("版本信息");
        JMenuItem jMenuItem14 = new JMenuItem("帮助信息");
        menu5.add(jMenuItem13);
        menu5.add(jMenuItem14);
    }

    public void load() {
        contentPanel = new JPanel();
//        setContentPane(contentPanel);
        setVisible(true);
    }

    private JPanel currentPanel;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (currentPanel != null) {
            remove(currentPanel);
        }
        if (e.getSource() == jMenuItem1) {
            ClassmateInfoUI classMateInfoUI = new ClassmateInfoUI();
            classMateInfoUI.loadData();
            getContentPane().add(classMateInfoUI, BorderLayout.CENTER);
            setVisible(true);
            currentPanel = classMateInfoUI;
        } else if (e.getSource() == jMenuItem2) {
            ClassmateCommunicationUI classmateCommunicationUI = new ClassmateCommunicationUI();
            classmateCommunicationUI.loadData();
            getContentPane().add(classmateCommunicationUI, BorderLayout.CENTER);
            setVisible(true);
            currentPanel = classmateCommunicationUI;
        } else if (e.getSource() == jMenuItem3) {
            ClassmateAddUI classmateAddUI = new ClassmateAddUI();
            getContentPane().add(classmateAddUI, BorderLayout.CENTER);
            setVisible(true);
            currentPanel = classmateAddUI;
        } else if (e.getSource() == jMenuItem10) {
            ClassmateSearchUI classmateSearchUI = new ClassmateSearchUI();
            getContentPane().add(classmateSearchUI, BorderLayout.CENTER);
            setVisible(true);
            currentPanel = classmateSearchUI;
        }

    }
}
