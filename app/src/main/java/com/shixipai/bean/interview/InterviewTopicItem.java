package com.shixipai.bean.interview;

/**
 * Created by xiepeng on 16/1/30.
 */
public class InterviewTopicItem {
    private int tid;
    private String title;
    private String image;

    public InterviewTopicItem() {
    }

    public InterviewTopicItem(int tid, String title, String image) {
        this.tid = tid;
        this.title = title;
        this.image = image;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
