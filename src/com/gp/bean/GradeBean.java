package com.gp.bean;

import java.util.SplittableRandom;

/**
 * @author gp
 * @create 2019/12/22 20:29
 */
public class GradeBean {
    private int id;
    private String stu_id;
    private String c_id;
    private String score;

    public GradeBean() {
    }

    public GradeBean(int id, String stu_id, String c_id, String score) {
        this.id = id;
        this.stu_id = stu_id;
        this.c_id = c_id;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
