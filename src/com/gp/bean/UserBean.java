package com.gp.bean;

/**
 * @author gp
 * @create 2019/12/21 23:21
 */
public class UserBean {
    private String username;
    private String password;
    private int identity;

    public UserBean(String username, String password, int identity) {
        this.username = username;
        this.password = password;
        this.identity = identity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
}
