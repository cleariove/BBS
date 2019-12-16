package cn.edu.ncu.bbs.domain;

import java.util.Date;

public class SubComment {
    private Integer subCommentId;

    private Integer subCommentFrom;

    private Integer subCommentTo;

    private String content;

    private Date date;

    private Integer commentId;

    public Integer getSubCommentId() {
        return subCommentId;
    }

    public void setSubCommentId(Integer subCommentId) {
        this.subCommentId = subCommentId;
    }

    public Integer getSubCommentFrom() {
        return subCommentFrom;
    }

    public void setSubCommentFrom(Integer subCommentFrom) {
        this.subCommentFrom = subCommentFrom;
    }

    public Integer getSubCommentTo() {
        return subCommentTo;
    }

    public void setSubCommentTo(Integer subCommentTo) {
        this.subCommentTo = subCommentTo;
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

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}