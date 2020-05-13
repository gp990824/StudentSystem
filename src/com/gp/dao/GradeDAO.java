package com.gp.dao;

import com.gp.bean.GradeBean;
import com.gp.bean.GradeViewBean;

import java.util.List;

/**
 * @author Gp
 * @create 2020/5/12 21:07
 */
public interface GradeDAO {
    List<GradeViewBean> queryAllStudentGrade();

    boolean deleteGradeById(int id);

    GradeViewBean queryGradeById(int id);

    boolean updateGradeInfo(GradeBean grade);

    List<String> queryAllClasses();

    boolean addGrade(GradeBean grade);

    List<GradeViewBean> queryGradeByName(String name);

    int queryClassIdByClassName(String name);
}
