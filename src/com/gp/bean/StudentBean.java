package com.gp.bean;

/**
 * @author gp
 * @create 2019/12/22 15:01
 */
public class StudentBean {
    private int id;
    private String name;
    private String password;
    private String sex;
    private String email;
    public StudentBean(){

    }

    public StudentBean(String name, String password, String sex, String email) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }

    public StudentBean(int id, String name, String password, String sex, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
