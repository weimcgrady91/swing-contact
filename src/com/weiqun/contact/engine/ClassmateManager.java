package com.weiqun.contact.engine;

import com.weiqun.contact.bean.Classmate;
import com.weiqun.contact.dao.ClassmateDao;

import java.util.List;

public class ClassmateManager {
    public static void add(Classmate classmate) {
        ClassmateDao.save(classmate);
    }

    public static Classmate fetch(String name) {
        Classmate classmate = ClassmateDao.find(name);
        return classmate;
    }

    public static void remove(String name){
        ClassmateDao.delete(name);
    }

    public static List<Classmate> fetchAll() {
        List<Classmate> classmates = ClassmateDao.findAll();
        return classmates;
    }
}
