package com.weiqun.contact.dao;

import com.weiqun.contact.bean.Classmate;
import com.weiqun.contact.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassmateDao {
    public static void save(Classmate classmate) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            String sql = "insert into classmate values(null,?,?,?,?,?,?,?,?,?,?)";
            conn = DBUtils.getConnection();
            pstmt = DBUtils.getPStamt(conn, sql);
            pstmt.setString(1, classmate.getName());
            pstmt.setString(2, classmate.getSex());
            pstmt.setString(3, classmate.getAddress());
            pstmt.setString(4, classmate.getHomeaddress());
            pstmt.setString(5, classmate.getCity());
            pstmt.setString(6, classmate.getCompany());
            pstmt.setString(7, classmate.getDuty());
            pstmt.setString(8, classmate.getSalary());
            pstmt.setString(9, classmate.getContanct());
            pstmt.setString(10, classmate.getHomephone());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                DBUtils.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static Classmate find(String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Classmate classmate = null;
        try {
            String sql = "select * from classmate where name=?";
            conn = DBUtils.getConnection();
            pstmt = DBUtils.getPStamt(conn, sql);
            pstmt.setString(1, name);
            ResultSet rs = DBUtils.getResultSet(pstmt);
            if (rs.next()) {
                classmate = createClassmateFromRs(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                DBUtils.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return classmate;
    }

    private static Classmate createClassmateFromRs(ResultSet rs) throws SQLException {
        Classmate classmate = new Classmate();
        classmate.setName(rs.getString("name"));
        classmate.setSex(rs.getString("sex"));
        classmate.setAddress(rs.getString("address"));
        classmate.setHomeaddress(rs.getString("homeaddress"));
        classmate.setCity(rs.getString("city"));
        classmate.setCompany(rs.getString("company"));
        classmate.setDuty(rs.getString("duty"));
        classmate.setSalary(rs.getString("salary"));
        classmate.setContanct(rs.getString("contact"));
        classmate.setHomephone(rs.getString("homephone"));
        return classmate;
    }

    public static void delete(String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            String sql = "delete from classmate where name=?";
            conn = DBUtils.getConnection();
            pstmt = DBUtils.getPStamt(conn, sql);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                DBUtils.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Classmate> findAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Classmate classmate = null;
        List<Classmate> classmates = new ArrayList<>();
        try {
            String sql = "select * from classmate";
            conn = DBUtils.getConnection();
            pstmt = DBUtils.getPStamt(conn, sql);
            ResultSet rs = DBUtils.getResultSet(pstmt);
            while (rs.next()) {
                classmate = createClassmateFromRs(rs);
                classmates.add(classmate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                DBUtils.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return classmates;
    }
}
