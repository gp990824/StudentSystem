package com.gp.servlet;

import com.gp.bean.StudentBean;
import com.gp.manager.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author gp
 * @create 2019/12/22 13:25
 */
@WebServlet("/StudentInfoManageServlet")
public class StudentInfoManageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        StudentService instance = StudentService.getInstance();
        List<StudentBean> students = instance.queryAllStudents();
        if (students != null) {
            request.setAttribute("list",students);
            request.getRequestDispatcher("/WEB-INF/jsp/studentInfo.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
