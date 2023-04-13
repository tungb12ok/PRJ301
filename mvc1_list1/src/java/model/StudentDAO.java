package model;

import java.util.*;
import java.sql.*;

public class StudentDAO extends MyDAO {

    public List<Student> getStudents() {
        List<Student> t = new ArrayList<>();
        xSql = "select * from Student";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xRollno, xName;
            float xMark;
            Student x;
            while (rs.next()) {
                xRollno = rs.getString("rollno");
                xName = rs.getString("name");
                xMark = rs.getFloat("mark");
                x = new Student(xRollno, xName, xMark);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    // input xRollno, output: student is searched
    public Student searchByRollno(String xRollno) {
        Student t = new Student();
        xSql = "select * from Student where rollno = '" + xRollno + "'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xName;
            float xMark;
            Student x;
            while (rs.next()) {
                xRollno = rs.getString("rollno");
                xName = rs.getString("name");
                xMark = rs.getFloat("mark");
                x = new Student(xRollno, xName, xMark);
                return (x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Student> searchByName(String xName) {
        List<Student> t = new ArrayList<>();
        xSql = "select * from Student where name lile '% "+xName+"%'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            String xRollno;
            float xMark;
            Student x;
            while (rs.next()) {
                xRollno = rs.getString("rollno");
                xName = rs.getString("name");
                xMark = rs.getFloat("mark");
                x = new Student(xRollno, xName, xMark);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

}
