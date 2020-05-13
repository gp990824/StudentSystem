package com.gp.dao;

import com.gp.bean.StudentBean;
import com.gp.bean.UserBean;
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
public class StudentDAOImpl implements StudentDAO {
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

    @Override
    public StudentBean queryStudentByName(String name) {
        try {
            connection = DBCP.getConnection();

            sql = "select * from register where name = ?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            resultSet = pstmt.executeQuery();
            StudentBean bean = new StudentBean();
            if (resultSet.next()) {
                bean.setId(resultSet.getInt(1));
                bean.setName(resultSet.getString(2));
                bean.setPassword(resultSet.getString(3));
                bean.setSex(resultSet.getString(4));
                bean.setEmail(resultSet.getString(5));
            }
            return bean;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            setNull();
        }
    }

    /**
     * 用于查询该管理员或学生是否存在
     *
     * @param user
     * @return
     */
    @Override
    public boolean queryUserIsExist(UserBean user) {
        try {
            connection = DBCP.getConnection();
            //首先判断是管理员登录还是学生登录
            if (user.getIdentity() == 1) {
                sql = "select password from manager where name = ?";
            } else {
                sql = "select * from student where name = ?";
            }

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getString(1).equals(user.getPassword())) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            setNull();
        }
    }

    /**
     * 查询所有学生
     *
     * @return
     */
    @Override
    public List<StudentBean> queryAllStudents() {
        try {
            connection = DBCP.getConnection();

            sql = "select * from register ";

            List<StudentBean> list = new ArrayList<>();
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                StudentBean bean = new StudentBean();
                bean.setId(resultSet.getInt(1));
                bean.setName(resultSet.getString(2));
                bean.setPassword(resultSet.getString(3));
                bean.setSex(resultSet.getString(4));
                bean.setEmail(resultSet.getString(5));
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
     * 根据 id 删除学生
     *
     * @param id
     * @return
     */
    @Override
    public boolean delStudentById(int id) {
        try {
            connection = DBCP.getConnection();
            sql = "delete from register where rid=?";

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
     * 根据装学生信息的javabean和id值修改学生信息,返回一个boolean值
     *
     * @param student
     * @return
     */
    @Override
    public boolean updateStudentInfo(StudentBean student) {
        try {
            connection = DBCP.getConnection();
            sql = "update register set name = ?, password = ?, sex = ?, email = ? where rid = ?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getPassword());
            pstmt.setString(3, student.getSex());
            pstmt.setString(4, student.getEmail());
            pstmt.setInt(5, student.getId());

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
     * 根据 id 删除学生
     *
     * @param id
     * @return
     */
    @Override
    public StudentBean queryStudentById(int id) {
        try {
            connection = DBCP.getConnection();
            sql = "select * from register where rid=?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            resultSet = pstmt.executeQuery();
            StudentBean student = new StudentBean();
            if (resultSet.next()) {
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setPassword(resultSet.getString(3));
                student.setSex(resultSet.getString(4));
                student.setEmail(resultSet.getString(5));
                return student;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            setNull();
        }
    }

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    @Override
    public boolean addStudent(StudentBean student) {
        try {
            connection = DBCP.getConnection();

            sql = "insert into register values(student_seq.nextval, ?, ?, ?, ?)";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getPassword());
            pstmt.setString(3, student.getSex());
            pstmt.setString(4, student.getEmail());

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
     * 查询所有学生名字
     *
     * @return
     */
    @Override
    public List<String> queryAllStudentName() {
        try {
            connection = DBCP.getConnection();

            sql = "select name from register";

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

    @Override
    public int queryStudentIdByStudentName(String name) {
        try {
            connection = DBCP.getConnection();

            sql = "select rid from register where name = ?";

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
}
