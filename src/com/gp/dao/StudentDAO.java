package com.gp.dao;

import com.gp.bean.StudentBean;
import com.gp.bean.UserBean;

import java.util.List;

/**
 * @author Gp
 * @create 2020/5/12 21:06
 */
public interface StudentDAO {
    StudentBean queryStudentByName(String name);

    boolean queryUserIsExist(UserBean user);

    List<StudentBean> queryAllStudents();

    boolean delStudentById(int id);

    boolean updateStudentInfo(StudentBean student);

    StudentBean queryStudentById(int id);

    boolean addStudent(StudentBean student);

    List<String> queryAllStudentName();

    int queryStudentIdByStudentName(String name);
}
