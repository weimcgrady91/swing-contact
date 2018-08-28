package com.weiqun.contact.ui;

import com.weiqun.contact.bean.Classmate;
import com.weiqun.contact.engine.ClassMateNameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ClassmateInfoUI extends JPanel implements ItemListener, ActionListener {


    private final JComboBox name;
    private ClassMateNameModel classMateNameModel;
    private final JTextField city;
    private final JTextField sex;
    private final JTextField company;
    private final JTextField address;
    private final JTextField duty;
    private final JTextField homeAddress;
    private final JTextField salary;

    public ClassmateInfoUI() {
//        setPreferredSize(new Dimension(650,400));
        setBackground(Color.YELLOW);
        setLayout(new GridBagLayout());
        JLabel title = new JLabel("同学基本信息");
        add(title, getConstraints(0, 0, 4, 1));
        JLabel nameLabel = new JLabel("姓名");
        add(nameLabel, getConstraints(0, 1, 1, 1));
        name = new JComboBox();
        name.addActionListener(this);
        add(name, getConstraints(1, 1, 1, 1));
        JLabel cityLabel = new JLabel("所在城市");
        add(cityLabel, getConstraints(2, 1, 1, 1));
        city = new JTextField(15);
        add(city, getConstraints(3, 1, 1, 1));

        JLabel sexLabel = new JLabel("性别");
        add(sexLabel, getConstraints(0, 2, 1, 1));
        sex = new JTextField(15);
        add(sex, getConstraints(1, 2, 1, 1));
        JLabel companyLabel = new JLabel("所在公司");
        add(companyLabel, getConstraints(2, 2, 1, 1));
        company = new JTextField(15);
        add(company, getConstraints(3, 2, 1, 1));

        JLabel addressLabel = new JLabel("居住地址");
        add(addressLabel, getConstraints(0, 3, 1, 1));
        address = new JTextField(15);
        add(address, getConstraints(1, 3, 1, 1));
        JLabel dutyLabel = new JLabel("职位");
        add(dutyLabel, getConstraints(2, 3, 1, 1));
        duty = new JTextField(15);
        add(duty, getConstraints(3, 3, 1, 1));

        JLabel homeAddressLabel = new JLabel("家庭地址");
        add(homeAddressLabel, getConstraints(0, 4, 1, 1));
        homeAddress = new JTextField(15);
        add(homeAddress, getConstraints(1, 4, 1, 1));

        JLabel salaryLabel = new JLabel("薪水");
        add(salaryLabel, getConstraints(2, 4, 1, 1));
        salary = new JTextField(15);
        add(salary, getConstraints(3, 4, 1, 1));
    }

    public GridBagConstraints getConstraints(int x, int y, int w, int h) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipadx = 10;
        constraints.ipady = 10;
        constraints.insets = new Insets(10, 10, 10, 10);
        return constraints;
    }

    public void loadData() {
        classMateNameModel = new ClassMateNameModel();
        name.setModel(classMateNameModel);
        fillData(classMateNameModel.getItem(0));
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println(name.getSelectedIndex());
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
        city.setText(classmate.getCity());
        sex.setText(classmate.getSex());
        company.setText(classmate.getCompany());
        address.setText(classmate.getAddress());
        duty.setText(classmate.getDuty());
        homeAddress.setText(classmate.getHomeaddress());
        salary.setText(classmate.getSalary());
    }
}
