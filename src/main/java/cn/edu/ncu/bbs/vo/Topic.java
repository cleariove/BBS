package cn.edu.ncu.bbs.vo;

import java.util.Date;

public class Topic {
    private Integer topicid;

    private String title;

    private String content;

    private Integer topicManager;

    private Date date;

    private Integer browse;

    private Integer integral;

    private Boolean help;

    private Boolean elite;

    private Boolean onpagetop;

    private Integer subitemid;

    public Integer getTopicid() {
        return topicid;
    }

    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getTopicmanager() {
        return topicManager;
    }

    public void setTopicmanager(Integer topicmanager) {
        this.topicManager = topicmanager;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getBrowse() {
        return browse;
    }

    public void setBrowse(Integer browse) {
        this.browse = browse;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Boolean getHelp() {
        return help;
    }

    public void setHelp(Boolean help) {
        this.help = help;
    }

    public Boolean getElite() {
        return elite;
    }

    public void setElite(Boolean elite) {
        this.elite = elite;
    }

    public Boolean getOnpagetop() {
        return onpagetop;
    }

    public void setOnpagetop(Boolean onpagetop) {
        this.onpagetop = onpagetop;
    }

    public Integer getSubitemid() {
        return subitemid;
    }

    public void setSubitemid(Integer subitemid) {
        this.subitemid = subitemid;
    }
}