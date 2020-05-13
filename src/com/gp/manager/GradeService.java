package com.gp.manager;

import com.gp.bean.GradeBean;
import com.gp.bean.GradeViewBean;
import com.gp.dao.GradeDAO;
import com.gp.dao.GradeDAOImpl;

import java.util.List;

/**
 * @author Gp
 * @create 2020/5/12 21:53
 */
public class GradeService {
    private GradeDAO grade = new GradeDAOImpl();
    private static volatile GradeService instance;

    private GradeService() {

    }

    public static GradeService getInstance() {
        if (instance == null) {
            synchronized (GradeService.class) {
                if (instance == null) {
                    instance = new GradeService();
                }
            }
        }
        return instance;
    }

    public synchronized GradeViewBean queryGradeById(int id) {
        return grade.queryGradeById(id);
    }

    public synchronized List<GradeViewBean> queryGradeByName(String name){
        return grade.queryGradeByName(name);
    }
    //查询成绩表,返回封装成绩的javabean集合
    public synchronized List<GradeViewBean> queryAllStudentGrade() {
        return grade.queryAllStudentGrade();
    }

    //根据成绩表的id删除成绩
    public synchronized boolean deleteGradeById(int id) {
        return grade.deleteGradeById(id);
    }


    //根据成绩javabean修改学生成绩
    public synchronized boolean updateGradeInfo(GradeBean gradeBean) {
        return grade.updateGradeInfo(gradeBean);
    }

    //查询所有课程
    public synchronized List<String> queryAllClasses() {
        return grade.queryAllClasses();
    }


    //根据传进来的学生姓名和课程名称添加学生信息
    public synchronized boolean addGrade(GradeViewBean grade) {
        String className = grade.getClassName();
        String studentName = grade.getStudentName();
        String score = grade.getScore();
        int studentId = StudentService.getInstance().queryStudentIdByStudentName(studentName);
        int classId = this.grade.queryClassIdByClassName(className);
        GradeBean gradeBean = new GradeBean();
        gradeBean.setClassId(classId);
        gradeBean.setStudentId(studentId);
        gradeBean.setScore(score);
        return this.grade.addGrade(gradeBean);
    }
}
