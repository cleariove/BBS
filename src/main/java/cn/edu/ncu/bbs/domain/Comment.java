package cn.edu.ncu.bbs.domain;

import java.util.Date;

public class Comment {
    private Integer commentId;//主键

    private Integer commentFrom;//评论者

    private Integer commentTo;//对谁的评论

    private String content;//评论内容

    private Date date;//评论时间

    private Integer topicId;//所属帖子的id

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentFrom() {
        return commentFrom;
    }

    public void setCommentFrom(Integer commentFrom) {
        this.commentFrom = commentFrom;
    }

    public Integer getCommentTo() {
        return commentTo;
    }

    public void setCommentTo(Integer commentTo) {
        this.commentTo = commentTo;
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

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }
}