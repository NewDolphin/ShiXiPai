package com.shixipai.bean;

/**
 * Created by xiepeng on 16/1/20.
 */
public class JobItem {
    private String id;
    private String area;
    private String start_time;
    private String title;
    private String company;
    private String salary;

    public JobItem(){

    }


    public JobItem(String id, String area, String start_time, String title, String company, String salary) {
        this.id = id;
        this.area = area;
        this.start_time = start_time;
        this.title = title;
        this.company = company;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
