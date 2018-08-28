package com.weiqun.contact.ui;

import com.weiqun.contact.bean.Classmate;
import com.weiqun.contact.engine.ClassMateNameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassmateCommunicationUI extends JPanel implements ActionListener {
    private final JComboBox name;
    private ClassMateNameModel classMateNameModel;
    private final JTextField homePhone;
    private final JTextField contact;

    public ClassmateCommunicationUI() {
//        setPreferredSize(new Dimension(650,400));
        setBackground(Color.YELLOW);
        setLayout(new GridBagLayout());
        JLabel title = new JLabel("同学联系方式");
        add(title, getConstraints(0, 0, 4, 1));
        JLabel nameLabel = new JLabel("姓名");
        add(nameLabel, getConstraints(0, 1, 2, 1));
        name = new JComboBox();
        name.addActionListener(this);
        add(name, getConstraints(2, 1, 2, 1));
        JLabel homePhoneLabel = new JLabel("家庭电话号码");
        add(homePhoneLabel, getConstraints(0, 2, 2, 1));
        homePhone = new JTextField(15);
        add(homePhone, getConstraints(2, 2, 2, 1));

        JLabel contactLabel = new JLabel("移动号码");
        add(contactLabel, getConstraints(0, 3, 2, 1));
        contact = new JTextField(15);
        add(contact, getConstraints(2, 3, 2, 1));

    }

    public GridBagConstraints getConstraints(int x, int y, int w, int h) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipadx = 20;
        constraints.ipady = 20;
        constraints.insets = new Insets(10, 10, 10, 10);
        return constraints;
    }

    public void loadData() {
        classMateNameModel = new ClassMateNameModel();
        name.setModel(classMateNameModel);
        fillData(classMateNameModel.getItem(0));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(name.getSelectedIndex());
        if (e.getSource() == name) {
            int index = name.getSelectedIndex();
            Classmate classmate = classMateNameModel.getItem(index);
            fillData(classmate);
        }
    }

    public void fillData(Classmate classmate) {
        homePhone.setText(classmate.getHomephone());
        contact.setText(classmate.getContanct());
    }
}
