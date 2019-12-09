package cn.edu.ncu.bbs.domain;


public class Topic {

  private long topicId;
  private String title;
  private String content;
  private long topicManager;
  private java.sql.Timestamp date;
  private long browse;
  private long integral;
  private boolean help;
  private boolean elite;
  private boolean onPageTop;
  private long subItemId;


  public long getTopicId() {
    return topicId;
  }

  public void setTopicId(long topicId) {
    this.topicId = topicId;
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


  public long getTopicManager() {
    return topicManager;
  }

  public void setTopicManager(long topicManager) {
    this.topicManager = topicManager;
  }


  public java.sql.Timestamp getDate() {
    return date;
  }

  public void setDate(java.sql.Timestamp date) {
    this.date = date;
  }


  public long getBrowse() {
    return browse;
  }

  public void setBrowse(long browse) {
    this.browse = browse;
  }


  public long getIntegral() {
    return integral;
  }

  public void setIntegral(long integral) {
    this.integral = integral;
  }


  public boolean getHelp() {
    return help;
  }

  public void setHelp(boolean help) {
    this.help = help;
  }


  public boolean getElite() {
    return elite;
  }

  public void setElite(boolean elite) {
    this.elite = elite;
  }


  public boolean getOnPageTop() {
    return onPageTop;
  }

  public void setOnPageTop(boolean onPageTop) {
    this.onPageTop = onPageTop;
  }


  public long getSubItemId() {
    return subItemId;
  }

  public void setSubItemId(long subItemId) {
    this.subItemId = subItemId;
  }

}
