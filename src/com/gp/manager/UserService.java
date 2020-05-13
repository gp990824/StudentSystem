package com.gp.manager;

import com.gp.bean.GradeBean;
import com.gp.bean.StudentBean;
import com.gp.bean.UserBean;
import com.gp.dao.StudentDAO;
import com.gp.dao.StudentDAOImpl;

import java.util.List;

/**
 * @author gp
 * @create 2019/12/21 23:20
 */
public class UserService {


    private StudentDAO student = new StudentDAOImpl();

    private static volatile UserService instance = null;

    static public UserService getInstance() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    instance = new UserService();
                }
            }
        }
        return instance;
    }

    private UserService() {

    }


    public boolean login(UserBean user) {
        return student.queryUserIsExist(user);
    }
}
