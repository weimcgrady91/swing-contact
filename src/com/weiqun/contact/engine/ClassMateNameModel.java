package com.weiqun.contact.engine;

import com.weiqun.contact.bean.Classmate;

import javax.swing.*;

public class ClassMateNameModel extends DefaultComboBoxModel<String> {
    java.util.List<Classmate> classmates;

    public ClassMateNameModel() {
        super();
        classmates = ClassmateManager.fetchAll();
        for (int i = 0; i < classmates.size(); i++) {
            addElement(classmates.get(i).getName());
        }
    }

    public Classmate getItem(int index) {
        return classmates.get(index);
    }
}
