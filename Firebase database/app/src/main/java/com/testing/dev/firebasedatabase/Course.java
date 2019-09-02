package com.testing.dev.firebasedatabase;

public class Course {
    private String title;
    private String code;
    private int credit;
    private String courseId;

    public Course() {
    }

    public Course(String title, String code, int credit) {
        this.title = title;
        this.code = code;
        this.credit = credit;
    }

    public Course(String title, String code, int credit, String courseId) {
        this.title = title;
        this.code = code;
        this.credit = credit;
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public int getCredit() {
        return credit;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
