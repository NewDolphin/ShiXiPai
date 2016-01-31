package com.shixipai.bean.interview;

/**
 * Created by xiepeng on 16/1/30.
 */
public class InterviewQuestionItem {
    private String title;
    private String answer;

    public InterviewQuestionItem(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }

    public InterviewQuestionItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
