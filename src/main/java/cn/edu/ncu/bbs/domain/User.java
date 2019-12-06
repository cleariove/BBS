package com.sample;


public class User {

  private long userId;
  private String userName;
  private String password;
  private long age;
  private String gender;
  private java.sql.Timestamp birthDay;
  private long power;
  private long integral;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public java.sql.Timestamp getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(java.sql.Timestamp birthDay) {
    this.birthDay = birthDay;
  }


  public long getPower() {
    return power;
  }

  public void setPower(long power) {
    this.power = power;
  }


  public long getIntegral() {
    return integral;
  }

  public void setIntegral(long integral) {
    this.integral = integral;
  }

}
