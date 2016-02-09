package com.shixipai.bean.edit;

import java.io.Serializable;

/**
 * Created by xiepeng on 16/2/5.
 */
public class EduInfo implements Serializable{
    private String school;
    private String level;
    private String end_time;
    private String major;

    public EduInfo() {
    }

    public EduInfo(String school, String level, String end_time, String major) {
        this.school = school;
        this.level = level;
        this.end_time = end_time;
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
