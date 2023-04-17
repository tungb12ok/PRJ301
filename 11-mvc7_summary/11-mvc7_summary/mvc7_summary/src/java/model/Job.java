/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tungl
 */
public class Job {
    private int No, Year_Of_Experience;
    private String Job_Title,Company,Description;

    public Job() {
    }

    public Job(int No, int Year_Of_Experience, String Job_Title, String Company, String Description) {
        this.No = No;
        this.Year_Of_Experience = Year_Of_Experience;
        this.Job_Title = Job_Title;
        this.Company = Company;
        this.Description = Description;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int No) {
        this.No = No;
    }

    public int getYear_Of_Experience() {
        return Year_Of_Experience;
    }

    public void setYear_Of_Experience(int Year_Of_Experience) {
        this.Year_Of_Experience = Year_Of_Experience;
    }

    public String getJob_Title() {
        return Job_Title;
    }

    public void setJob_Title(String Job_Title) {
        this.Job_Title = Job_Title;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
