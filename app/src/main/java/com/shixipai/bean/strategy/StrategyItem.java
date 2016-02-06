package com.shixipai.bean.strategy;

import java.io.Serializable;

/**
 * Created by xiepeng on 16/2/6.
 */
public class StrategyItem implements Serializable{
    private String title;
    private String content;
    private String updated_at;
    private String img;

    public StrategyItem() {
    }

    public StrategyItem(String title, String content, String updated_at, String img) {
        this.title = title;
        this.content = content;
        this.updated_at = updated_at;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
