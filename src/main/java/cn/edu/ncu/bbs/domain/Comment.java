package com.sample;


public class Comment {

  private long commentId;
  private long commentFrom;
  private long commentTo;
  private String content;
  private java.sql.Timestamp date;
  private long topicId;


  public long getCommentId() {
    return commentId;
  }

  public void setCommentId(long commentId) {
    this.commentId = commentId;
  }


  public long getCommentFrom() {
    return commentFrom;
  }

  public void setCommentFrom(long commentFrom) {
    this.commentFrom = commentFrom;
  }


  public long getCommentTo() {
    return commentTo;
  }

  public void setCommentTo(long commentTo) {
    this.commentTo = commentTo;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public java.sql.Timestamp getDate() {
    return date;
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }


  public long getTopicId() {
    return topicId;
  }

  public void setTopicId(long topicId) {
    this.topicId = topicId;
  }

}
