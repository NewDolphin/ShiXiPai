package com.shixipai.bean;

/**
 * Created by xiepeng on 16/1/25.
 */
public class JobDetail {
    private String title;
    private String company;
    private String area;
    private String salary;
    private String education;
    private String info;
    private String company_image;

    public JobDetail(){

    }

    public JobDetail(String title, String company, String area, String salary, String education,
                     String info, String company_image) {
        this.title = title;
        this.company = company;
        this.area = area;
        this.salary = salary;
        this.education = education;
        this.info = info;
        this.company_image = company_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCompany_image() {
        return company_image;
    }

    public void setCompany_image(String company_image) {
        this.company_image = company_image;
    }
}
