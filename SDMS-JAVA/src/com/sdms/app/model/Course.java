package com.sdms.model;

public class Course {

    private int courseId;
    private String courseCode;
    private String courseName;
    private String department;
    private int durationYears;
    private int totalSemesters;
    private double feesPerSemester;
    private double totalFees;
    private String eligibility;
    private String courseType;
    private int startYear;
    private String status;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDurationYears() {
        return durationYears;
    }

    public void setDurationYears(int durationYears) {
        this.durationYears = durationYears;
    }

    public int getTotalSemesters() {
        return totalSemesters;
    }

    public void setTotalSemesters(int totalSemesters) {
        this.totalSemesters = totalSemesters;
        calculateTotalFees();
    }

    public double getFeesPerSemester() {
        return feesPerSemester;
    }

    // IMPORTANT: integer ya .00 dono safe rahenge
    public void setFeesPerSemester(double feesPerSemester) {
        this.feesPerSemester = feesPerSemester;
        calculateTotalFees();
    }

    public double getTotalFees() {
        return totalFees;
    }

    private void calculateTotalFees() {
        this.totalFees = this.feesPerSemester * this.totalSemesters;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public double setTotalFees() {return totalFees;}
}
