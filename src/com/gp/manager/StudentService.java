package com.gp.manager;

import com.gp.bean.StudentBean;
import com.gp.dao.StudentDAO;
import com.gp.dao.StudentDAOImpl;

import java.util.List;

/**
 * @author Gp
 * @create 2020/5/12 21:53
 */
public class StudentService {
    private StudentDAO student = new StudentDAOImpl();
    private static volatile StudentService instance;

    private StudentService() {

    }

    public static StudentService getInstance() {
        if (instance == null) {
            synchronized (StudentService.class) {
                if (instance == null) {
                    instance = new StudentService();
                }
            }
        }
        return instance;
    }

    public StudentBean queryStudentByName(String name) {
        return student.queryStudentByName(name);
    }

    public int queryStudentIdByStudentName(String name) {
        return student.queryStudentIdByStudentName(name);
    }

    public List<StudentBean> queryAllStudents() {
        return student.queryAllStudents();
    }

    public boolean delStudentById(int id) {
        return student.delStudentById(id);
    }

    public StudentBean queryStudentById(int id) {
        return student.queryStudentById(id);
    }

    public boolean updateStudentInfo(StudentBean student) {
        return this.student.updateStudentInfo(student);
    }

    public boolean addStudent(StudentBean student) {
        return this.student.addStudent(student);
    }

    public List<String> queryAllStudentName() {
        return student.queryAllStudentName();
    }
}
