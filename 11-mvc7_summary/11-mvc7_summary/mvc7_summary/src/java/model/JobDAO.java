/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tungl
 */
public class JobDAO extends MyDAO {

    public List<Job> getJob() {
        List<Job> t = new ArrayList<>();
        xSql = "select * from JobDB";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xNo, xYear_Of_Experience;
            String xJob_Title, xCompany, xDescription;
            Job x;
            while (rs.next()) {

                xNo = rs.getInt(1);
                xYear_Of_Experience = rs.getInt(4);
                xJob_Title = rs.getString(2);
                xCompany = rs.getString(3);
                xDescription = rs.getString(5);
                x = new Job(xNo, xYear_Of_Experience, xJob_Title, xCompany, xDescription);
                t.add(x);
            }

            rs.close();

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public void delete(int xNo) {
        xSql = "delete from JobDB where No=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xNo);
            ps.executeUpdate();
            //con.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(int xNo, Job x) {
        xSql = "update JobDB set [Job Title]=?, [Company]=?, [Year of Experience] = ? Decription = ? where No=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getJob_Title());
            ps.setString(2, x.getCompany());
            ps.setInt(3, x.getYear_Of_Experience());
            ps.setString(4, x.getDescription());
            ps.setInt(5, xNo);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Job getJob(int xNo) {
        Job x = null;
        xSql = "select * from JobDB where No = " + xNo;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xYear_Of_Experience;
            String xJob_Title, xCompany, xDescription;

            while (rs.next()) {

                xNo = rs.getInt(1);
                xYear_Of_Experience = rs.getInt(4);
                xJob_Title = rs.getString(2);
                xCompany = rs.getString(3);
                xDescription = rs.getString(5);
                x = new Job(xNo, xYear_Of_Experience, xJob_Title, xCompany, xDescription);
                return x;
            }

            rs.close();

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

}
