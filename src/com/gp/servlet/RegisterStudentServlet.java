package com.gp.servlet;

import com.gp.bean.StudentBean;
import com.gp.manager.StudentService;
import com.gp.manager.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gp
 * @create 2019/12/22 19:39
 */
@WebServlet("/RegisterStudentServlet")
public class RegisterStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        StudentBean student = new StudentBean(name, password, sex, email);
        StudentService instance = StudentService.getInstance();
        boolean flag = instance.addStudent(student);
        if (flag) {
            response.sendRedirect("/index.jsp");
        } else {
            response.sendRedirect("/registererror.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
