package com.shixipai.bean.edit;

/**
 * Created by xiepeng on 16/2/5.
 */
public class ProjectInfo {
    private String title;
    private String start_time;
    private String end_time;
    private String content;

    public ProjectInfo() {
    }

    public ProjectInfo(String title, String start_time, String end_time, String content) {
        this.title = title;
        this.start_time = start_time;
        this.end_time = end_time;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
