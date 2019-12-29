package com.gp.dao;

import com.gp.bean.GradeBean;
import com.gp.bean.StudentBean;
import com.gp.bean.UserBean;

import java.util.List;

/**
 * @author gp
 * @create 2019/12/21 23:20
 */
public interface InterfaceDao {
    public boolean queryUser(UserBean user) ;//查询用户是否存在
    public List<StudentBean> queryAllStudents();//查询所有学生
    public boolean delStudent(int id);//根据id值删除学生,并返回一个布尔值
    public boolean updateStudent(StudentBean student); //根据封装学生信息的javabaen和id值修改学生信息,然后返回一个布尔值
    public StudentBean queryStudentByid(int id);//根据id查找该学生
    public boolean addStudent(StudentBean student);//添加学生

    public List<GradeBean> queryStudentGrade();//查询所有学生的成绩,返回一个封装学生成绩的javabaen
    public boolean deleteGrade(int id);//根据成绩表的id删除分数
    public GradeBean queryGradeByid(int id);//根据id查询学生信息
    public boolean updateGrade(GradeBean grade);//修改学生成绩
    public List<String> queryTotalClass();//查询所有课程
    public List<String> queryTotalStudentName();//查询所有学生姓名
    public boolean addGrade(String studentname,String classname,String score);//根据传进来的学生姓名和课程名称添加学生信息
    public int queryGradeMaxId();//查询成绩表中最大id值
    public int queryRegisterMaxId();//查询学生表中的最大id值
}
