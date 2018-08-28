package com.weiqun.contact.ui;

import com.weiqun.contact.bean.Classmate;
import com.weiqun.contact.engine.ClassMateNameModel;
import com.weiqun.contact.engine.ClassmateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassmateAddUI extends JPanel implements ActionListener {
    private final JTextField city;
    private final JTextField sex;
    private final JTextField company;
    private final JTextField address;
    private final JTextField duty;
    private final JTextField homeAddress;
    private final JTextField salary;
    private final JTextField name;
    private final JTextField homePhone;
    private final JTextField contact;
    private final JButton addBtn;

    public ClassmateAddUI() {
        setBackground(Color.YELLOW);
        setLayout(new GridBagLayout());
        JLabel title = new JLabel("同学基本信息");
        add(title, getConstraints(0, 0, 4, 1));
        JLabel nameLabel = new JLabel("姓名");
        add(nameLabel, getConstraints(0, 1, 1, 1));
        name = new JTextField(15);
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

        JLabel homePhoneLabel = new JLabel("家庭电话号码");
        add(homePhoneLabel, getConstraints(0, 5, 1, 1));
        homePhone = new JTextField(15);
        add(homePhone, getConstraints(1, 5, 1, 1));

        JLabel contactLabel = new JLabel("移动号码");
        add(contactLabel, getConstraints(2, 5, 1, 1));
        contact = new JTextField(15);
        add(contact, getConstraints(3, 5, 1, 1));
        addBtn = new JButton("添加");
        addBtn.addActionListener(this);
        add(addBtn, getConstraints(0, 6, 4, 1));
    }

    public GridBagConstraints getConstraints(int x, int y, int w, int h) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipadx = 9;
        constraints.ipady = 9;
        constraints.insets = new Insets(10, 10, 10, 10);
        return constraints;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            Classmate classmate = new Classmate();
            classmate.setName(name.getText());
            classmate.setSex(sex.getText());
            classmate.setCity(city.getText());
            classmate.setCompany(company.getText());
            classmate.setAddress(address.getText());
            classmate.setDuty(duty.getText());
            classmate.setHomephone(homePhone.getText());
            classmate.setHomeaddress(homeAddress.getText());
            classmate.setSalary(salary.getText());
            classmate.setContanct(contact.getText());
            ClassmateManager.add(classmate);
            JOptionPane.showMessageDialog(null, "添加成功!", "添加同学通讯录提示", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
