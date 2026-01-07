package com.sdms.app.model;

public class Student {

    private int studentId;
    private String name;
    private String rollNo;
    private String course;
    private int courseDuration;
    private String joinDate;
    private String leaveDate;
    private String status; // ACTIVE / LEFT

    // -------- GETTERS --------
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getCourse() {
        return course;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public String getStatus() {
        return status;
    }

    // -------- SETTERS --------
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setCourseDuration(int courseDuration) {
        this.courseDuration = courseDuration;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public void setStatus(String status) {
        this.status= status;
    }
}

