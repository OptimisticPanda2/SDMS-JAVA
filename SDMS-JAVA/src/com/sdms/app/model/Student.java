package com.sdms.app.model;

public class Student {
    private int studentId;
    private String rollNo;
    private String firstName;
    private String lastName;

    public int getStudentId() {
        return studentId;   
    }
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    public String getRollNo(){
        return rollNo;
    }
    public void setRollNo(String rollNo){
        this.rollNo = rollNo;
    }
    public String getFirstName(){
        return firstName;
    }  
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}
