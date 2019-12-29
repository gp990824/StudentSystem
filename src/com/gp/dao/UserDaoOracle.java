package com.gp.dao;

import com.gp.bean.GradeBean;
import com.gp.bean.StudentBean;
import com.gp.bean.UserBean;
import com.gp.datasource.DBCP;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gp
 * @create 2019/12/21 23:21
 */
public class UserDaoOracle implements InterfaceDao {

//    public static void main(String[] args) {
//        InterfaceDao interfaceDao = new UserDaoOracle();
////        System.out.println(interfaceDao.queryGradeMaxId());
//        System.out.println(interfaceDao.queryRegisterMaxId());
//    }


    Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet resultSet = null;
    String sql = null;

    // 用于查询该管理员是否存在,返回一个布尔值
    public boolean queryUser(UserBean user) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //查询所有学生
    public List<StudentBean> queryAllStudents() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();

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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //根据id删除学生
    public boolean delStudent(int id) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();
            sql = "delete from register where rid=?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            int result = pstmt.executeUpdate();

            if (result != -1) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //根据装学生信息的javabean和id值修改学生信息,返回一个boolean值
    public boolean updateStudent(StudentBean student) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();
            sql = "update register set name=? , password=? , sex=? , email=? where rid=?";

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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    //根据id查找该学生
    public StudentBean queryStudentByid(int id) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();
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
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

   //根据传进来的封装学生信息的javabean来增加学生,并且每增加一个学生,id就会加一
    public boolean addStudent(StudentBean student) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();

            sql = "insert into register values(?,?,?,?,?)";
            UserDaoOracle oracle = new UserDaoOracle();
            int Stu_id = oracle.queryRegisterMaxId();
            Stu_id++;//让学生表最大id值加一,防止插入数据时违反唯一约束条件

            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, Stu_id);
            pstmt.setString(2,student.getName());
            pstmt.setString(3,student.getPassword());
            pstmt.setString(4,student.getSex());
            pstmt.setString(5,student.getEmail());

            int result = pstmt.executeUpdate();

            if (result != -1) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

   //查询所有成绩,返回一个list集合
    public List<GradeBean> queryStudentGrade() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();

            //三表级联查询,使用左连接显示学生表的id和姓名 显示课程表的课程名 显示成绩表的成绩
            sql = "select g.gid,r.name,c.class,g.grade from grade g left join register r on g.stu_id=r.rid left join class c on g.class_id=c.cid";

            List<GradeBean> list = new ArrayList<>();
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                GradeBean bean = new GradeBean();
                bean.setId(resultSet.getInt(1));
                bean.setStu_id(resultSet.getString(2));
                bean.setC_id(resultSet.getString(3));
                bean.setScore(resultSet.getString(4));
                list.add(bean);
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //根据成绩表的id修改分数,返回一个boolean值
    public boolean deleteGrade(int id) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();
            sql = "delete from grade where gid=?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            int result = pstmt.executeUpdate();

            if (result != -1) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //根据id查询学生信息,返回一个封装学生成绩的javabean
    public GradeBean queryGradeByid(int id) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();
            sql = "select * from (select g.gid,r.name,c.class,g.grade from \n" +
                    "grade g left join register r on g.stu_id=r.rid \n" +
                    "left join class c on g.class_id=c.cid) where gid=?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            resultSet = pstmt.executeQuery();
            GradeBean student = new GradeBean();
            if (resultSet.next()) {
                student.setId(resultSet.getInt(1));
                student.setStu_id(resultSet.getString(2));
                student.setC_id(resultSet.getString(3));
                student.setScore(resultSet.getString(4));
                return student;
            }
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //修改学生成绩
    public boolean updateGrade(GradeBean student) {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();
            sql = "update GRADE set grade=? where gid=?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, student.getScore());
            pstmt.setInt(2,student.getId());

            int i = pstmt.executeUpdate();

            if (i != -1) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //查询所有课程
    public List<String> queryTotalClass() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();

            sql = "select class from class ";

            List<String> list = new ArrayList<>();
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public List<String> queryTotalStudentName() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();

            sql = "select name from register ";

            List<String> list = new ArrayList<>();
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    //根据学生名查询对应的id,id为返回值
    public int queryIdByStudentName(String studenName){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();
            sql = "select rid from register where name=?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, studenName);

            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
            return 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    //根据课程名称查询对应的id,id为返回值
    public int queryIdByClassName(String className){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();
            sql = "select cid from class where class=?";

            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, className);

            resultSet = pstmt.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
            return 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    //查询学生表中的最大id值
    public int queryRegisterMaxId() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();

            sql = "select rid from REGISTER";

            pstmt = connection.prepareStatement(sql);

            resultSet = pstmt.executeQuery();

            int maxId = 1;
            while (resultSet.next()) {
                if(resultSet.getInt(1)>maxId) {
                    maxId = resultSet.getInt(1);
                }
            }
            return maxId;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    //查询成绩表中的最大id值
    public int queryGradeMaxId(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();

            sql = "select gid from grade";

            pstmt = connection.prepareStatement(sql);

            resultSet = pstmt.executeQuery();

            int maxId = 1;
            while (resultSet.next()) {
                if(resultSet.getInt(1)>maxId) {
                    maxId = resultSet.getInt(1);
                }
            }
            return maxId;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



    //添加学生成绩
    public boolean addGrade(String studentname,String classname,String score) {
        UserDaoOracle oracle = new UserDaoOracle();
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DBCP.getDataSource().getConnection();

            sql = "insert into grade values(?,?,?,?)";

            int g_id = oracle.queryGradeMaxId();
            g_id++;//让成绩表中的最大id值加一,防止插入数据时违反唯一约束条件
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,g_id);
            int s = oracle.queryIdByStudentName(studentname);
            pstmt.setInt(2,s);
            int c = oracle.queryIdByClassName(classname);
            pstmt.setInt(3,c);
            pstmt.setString(4,score);

            int result = pstmt.executeUpdate();

            if (result != -1) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
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
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}



