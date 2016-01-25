package com.shixipai.bean;

/**
 * Created by xiepeng on 16/1/20.
 */
public class JobItem {
    private int id;
    private String area;
    private String start_time;
    private String title;
    private String company;
    private String salary;
    //0表示未投递，1表示已投递
    private int posted;

    public JobItem(){

    }


    public JobItem(int id, String area, String start_time, String title, String company,
                   String salary, int posted) {
        this.id = id;
        this.area = area;
        this.start_time = start_time;
        this.title = title;
        this.company = company;
        this.salary = salary;
        this.posted = posted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getPosted() {
        return posted;
    }

    public void setPosted(int posted) {
        this.posted = posted;
    }
}
