package com.gp.bean;

/**
 * @author Gp
 * @create 2020/5/13 9:46
 */
public class GradeViewBean {
    private int id;
    private String studentName;
    private String className;
    private String score;

    public GradeViewBean(int id, String studentName, String className, String score) {
        this.id = id;
        this.studentName = studentName;
        this.className = className;
        this.score = score;
    }

    public GradeViewBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
