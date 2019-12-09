package cn.edu.ncu.bbs.domain;

import java.util.Date;

public class Comment {
    private Integer commentid;

    private Integer commentfrom;

    private Integer commentto;

    private String content;

    private Date date;

    private Integer topicid;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getCommentfrom() {
        return commentfrom;
    }

    public void setCommentfrom(Integer commentfrom) {
        this.commentfrom = commentfrom;
    }

    public Integer getCommentto() {
        return commentto;
    }

    public void setCommentto(Integer commentto) {
        this.commentto = commentto;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTopicid() {
        return topicid;
    }

    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }
}