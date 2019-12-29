package com.gp.manager;

import com.gp.bean.GradeBean;
import com.gp.bean.StudentBean;
import com.gp.bean.UserBean;
import com.gp.dao.InterfaceDao;
import com.gp.dao.UserDaoOracle;

import java.util.List;

/**
 * @author gp
 * @create 2019/12/21 23:20
 */
public class UserManager {

    InterfaceDao interfaceDao  = new UserDaoOracle();//实现接口,并让其成为该类的成员属性

    static private volatile UserManager instance=null;

    static public UserManager getInstance() {
        if(instance==null){
            synchronized (UserManager.class){
                if (instance == null) {
                    instance=new UserManager();
                }
            }
        }
        return instance;
    }

    /*
    给每一个方法加锁,防止出现线程不安全的问题
     */

    //用于查询管理员的密码是否存在并且正确
    public synchronized boolean login(UserBean user) {
        return interfaceDao.queryUser(user);
    }

    //查询所有学生,返回封账学生信息的javabean集合
    public synchronized List<StudentBean> queryAllStudents(){
        return interfaceDao.queryAllStudents();
    }
    //根据id删除学生
    public synchronized boolean delStudent(int id){
        return interfaceDao.delStudent(id);
    }
    //根据学生id查询学生信息,返回封装学生信息的javabean
    public synchronized StudentBean queryStudentByid(int id){
        return interfaceDao.queryStudentByid(id);
    }
    //修改学生信息
    public synchronized boolean updateStudent(StudentBean student){
        return interfaceDao.updateStudent(student);
    }
    //添加学生
    public synchronized boolean addStudent(StudentBean student){
        return interfaceDao.addStudent(student);
    }

    //查询成绩表,返回封装成绩的javabean集合
    public synchronized List<GradeBean> queryStudentGrade(){
        return interfaceDao.queryStudentGrade();
    }
    //根据成绩表的id删除成绩
    public synchronized boolean deleteGrade(int id){
        return interfaceDao.deleteGrade(id);
    }
    //根据id查询学生信息,返回一个封装学生成绩的javabean
    public synchronized GradeBean queryGradeByid(int id){
        return interfaceDao.queryGradeByid(id);
    }
    //根据成绩javabean修改学生成绩
    public synchronized boolean updateGrade(GradeBean gradeBean){
        return interfaceDao.updateGrade(gradeBean);
    }
    //查询所有课程
    public synchronized List<String> queryTotalClass(){
        return interfaceDao.queryTotalClass();
    }
    //查询所有学生姓名
    public synchronized List<String> queryTotalStudentName(){
        return interfaceDao.queryTotalStudentName();
    }
    //根据传进来的学生姓名和课程名称添加学生信息
    public synchronized boolean addGrade(String studentname,String classname,String score){
        return interfaceDao.addGrade(studentname,classname,score);
    }

}
