package com.gp.dao;

import com.gp.bean.GradeBean;
import com.gp.bean.GradeViewBean;
import com.gp.datasource.DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gp
 * @create 2020/5/12 21:07
 */
public class GradeDAOImpl implements GradeDAO {
    private void setNull() {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet resultSet = null;
    private String sql = null;

    /**
     * 查询所有课程
     *
     * @return
     */
    @Override
    public List<String> queryAllClasses() {
        try {
            connection = DBCP.getConnection();

            sql = "select class from class ";

            List<String> list = new ArrayList<>();
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            setNull();
        }
    }

    /**
     * 查询所有成绩
     *
     * @return
     */
    @Override
    public List<GradeViewBean> queryAllStudentGrade() {
        try {
            connection = DBCP.getConnection();

            sql = "select *from gradeview";

            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            List<GradeViewBean> list = new ArrayList<>();
            while (resultSet.next()) {
                GradeViewBean bean = new GradeViewBean();
                bean.setId(resultSet.getInt(1));
                bean.setStudentName(resultSet.getString(2));
                bean.setClassName(resultSet.getString(3));
                bean.setScore(resultSet.getString(4));
                list.add(bean);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            setNull();
        }
    }

    /**
     * 根据成绩表的id修改分数
     *
     * @param id
     * @return
     */
    @Override
    public boolean deleteGradeById(int id) {
        try {
            connection = DBCP.getConnection();
            sql = "delete from grade where gid = ?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            int result = pstmt.executeUpdate();

            if (result != -1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            setNull();
        }
    }

    /**
     * 根据id查询学生信息
     *
     * @param id
     * @return
     */
    @Override
    public GradeViewBean queryGradeById(int id) {
        try {
            connection = DBCP.getConnection();
            sql = "select *from gradeview where gid = ?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            resultSet = pstmt.executeQuery();
            GradeViewBean student = new GradeViewBean();
            if (resultSet.next()) {
                student.setId(resultSet.getInt(1));
                student.setStudentName(resultSet.getString(2));
                student.setClassName(resultSet.getString(3));
                student.setScore(resultSet.getString(4));
            }
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            setNull();
        }
    }

    /**
     * 修改学生成绩
     *
     * @param student
     * @return
     */
    @Override
    public boolean updateGradeInfo(GradeBean student) {
        try {
            connection = DBCP.getConnection();
            sql = "update GRADE set grade=? where gid = ?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, student.getScore());
            pstmt.setInt(2, student.getId());

            int i = pstmt.executeUpdate();

            if (i != -1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            setNull();
        }
    }




    /**
     * 根据课程名称查询对应的id
     *
     * @param name
     * @return
     */
    @Override
    public int queryClassIdByClassName(String name) {
        try {
            connection = DBCP.getConnection();
            sql = "select cid from class where class = ?";

            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, name);

            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            setNull();
        }
    }

    /**
     * 添加学生成绩
     *
     * @param grade
     * @return
     */
    @Override
    public boolean addGrade(GradeBean grade) {
        try {
            connection = DBCP.getConnection();

            sql = "insert into grade values(grade_seq.nextval, ?, ?, ?)";

            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, grade.getStudentId());
            pstmt.setInt(2, grade.getClassId());
            pstmt.setString(3, grade.getScore());

            int result = pstmt.executeUpdate();

            if (result != -1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            setNull();
        }
    }

    @Override
    public List<GradeViewBean> queryGradeByName(String name) {
        try {
            connection = DBCP.getConnection();
            sql = "select * from gradeview where name = ?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);

            resultSet = pstmt.executeQuery();
            ArrayList<GradeViewBean> grades = new ArrayList<>();
            while (resultSet.next()) {
                GradeViewBean grade = new GradeViewBean();
                grade.setId(resultSet.getInt(1));
                grade.setStudentName(resultSet.getString(2));
                grade.setClassName(resultSet.getString(3));
                grade.setScore(resultSet.getString(4));
                grades.add(grade);
            }
            return grades;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            setNull();
        }
    }

}
