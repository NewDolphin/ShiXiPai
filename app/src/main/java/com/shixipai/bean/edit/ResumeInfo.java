package com.shixipai.bean.edit;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by xiepeng on 16/2/8.
 */
public class ResumeInfo implements Serializable{
    private BaseInfo baseInfo;
    private ArrayList<EduInfo> eduInfos;
    private ArrayList<ProjectInfo> projectInfos;
    private WantInfo wantInfo;


    public ResumeInfo() {
        eduInfos = new ArrayList<EduInfo>();
        projectInfos = new ArrayList<ProjectInfo>();
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public ArrayList<EduInfo> getEduInfos() {
        return eduInfos;
    }

    public void setEduInfos(ArrayList<EduInfo> eduInfos) {
        this.eduInfos = eduInfos;
    }

    public ArrayList<ProjectInfo> getProjectInfos() {
        return projectInfos;
    }

    public void setProjectInfos(ArrayList<ProjectInfo> projectInfos) {
        this.projectInfos = projectInfos;
    }

    public WantInfo getWantInfo() {
        return wantInfo;
    }

    public void setWantInfo(WantInfo wantInfo) {
        this.wantInfo = wantInfo;
    }
}
