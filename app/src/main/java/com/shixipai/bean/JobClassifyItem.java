package com.shixipai.bean;


/**
 * Created by xiepeng on 16/1/23.
 */
public class JobClassifyItem {
    private String classifyName;
    private int classifyPic;

    public JobClassifyItem(String classifyName, int classifyPic) {
        this.classifyName = classifyName;
        this.classifyPic = classifyPic;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public int getClassifyPic() {
        return classifyPic;
    }

    public void setClassifyPic(int classifyPic) {
        this.classifyPic = classifyPic;
    }
}
