package com.gp.bean;

/**
 * @author gp
 * @create 2019/12/22 20:29
 */
public class GradeBean {
    private int id;
    private int studentId;
    private int classId;
    private String score;

    public GradeBean() {
    }

    public GradeBean(int studentId, int classId, String score) {
        this.studentId = studentId;
        this.classId = classId;
        this.score = score;
    }

    public GradeBean(int id, int studentId, int classId, String score) {
        this.id = id;
        this.studentId = studentId;
        this.classId = classId;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
