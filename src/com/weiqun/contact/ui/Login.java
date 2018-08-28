package com.weiqun.contact.ui;

import com.weiqun.contact.util.LocationUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends JFrame implements ActionListener {
    private final static int WIDTH = 300;
    private final static int HEIGHT = 150;
    private JTextField usernameInput;
    private JPasswordField passwordInput;
    private JButton loginBtn;
    private JButton cancelBtn;

    public Login() {
        setTitle("欢迎登录通讯管理系统");
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
    }


    public void launcher() {
        Box h1 = Box.createHorizontalBox();
        JLabel username = new JLabel("username:");
        usernameInput = new JTextField(15);
        h1.add(username);
        h1.add(Box.createHorizontalStrut(20));
        h1.add(usernameInput);

        Box h2 = Box.createHorizontalBox();
        JLabel password = new JLabel("password:");
        passwordInput = new JPasswordField(15);
        h2.add(password);
        h2.add(Box.createHorizontalStrut(20));
        h2.add(passwordInput);

        Box h3 = Box.createHorizontalBox();
        loginBtn = new JButton("Login");
        loginBtn.addActionListener(this);
        cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(this);

        h3.add(loginBtn);
        h3.add(Box.createHorizontalStrut(20));
        h3.add(cancelBtn);

        Box v1 = Box.createVerticalBox();
        v1.add(Box.createVerticalStrut(20));
        v1.add(h1);
        v1.add(Box.createVerticalStrut(10));
        v1.add(h2);
        v1.add(Box.createVerticalStrut(10));
        v1.add(h3);

        JPanel jPanel = new JPanel();
        jPanel.add(v1, BorderLayout.CENTER);
        setContentPane(jPanel);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginBtn) {
            String username = usernameInput.getText();
            String password = new String(passwordInput.getPassword());
            if ("root".equals(username) && "root".equals(password)) {
                new MainUI().load();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "用户名或密码错误!", "登录失败", JOptionPane.ERROR_MESSAGE);
                usernameInput.setText("");
                passwordInput.setText("");
            }
        }
        if (e.getSource() == cancelBtn) {
            dispose();
        }
    }
}
