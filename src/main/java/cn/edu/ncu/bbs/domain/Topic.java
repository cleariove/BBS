package cn.edu.ncu.bbs.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.nashorn.internal.objects.annotations.Constructor;

import java.util.Date;


public class Topic {

    private Integer topicId;//主键

    private String title;//帖子标题

    private String content;//帖子内容

    private Integer manager;//贴主

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;//发帖时间

    private Integer browse;//浏览数量

    private Integer integral;//积分

    private Boolean help;//是否为求助帖

    private Boolean elite;//是否加精

    private Boolean onPageTop;//是否置顶

    private Integer subItemId;//所属子栏目id

    public Topic(Integer topicId, String title, String content, Integer manager, Date date, Integer browse, Integer integral, Boolean help, Boolean elite, Boolean onPageTop, Integer subItemId) {
        this.topicId = topicId;
        this.title = title;
        this.content = content;
        this.manager = manager;
        this.date = date;
        this.browse = browse;
        this.integral = integral;
        this.help = help;
        this.elite = elite;
        this.onPageTop = onPageTop;
        this.subItemId = subItemId;
    }

    public Topic(){

    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
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

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
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

    public Boolean getOnPageTop() {
        return onPageTop;
    }

    public void setOnPageTop(Boolean onPageTop) {
        this.onPageTop = onPageTop;
    }

    public Integer getSubItemId() {
        return subItemId;
    }

    public void setSubItemId(Integer subItemId) {
        this.subItemId = subItemId;
    }
}