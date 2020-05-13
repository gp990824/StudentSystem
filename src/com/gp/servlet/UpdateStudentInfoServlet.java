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
 * @create 2019/12/22 16:42
 */
@WebServlet("/UpdateStudentInfoServlet")
public class UpdateStudentInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        int id = Integer.parseInt(request.getParameter("id"));
        StudentBean student = new StudentBean(id, name, password, sex, email);
        StudentService instance = StudentService.getInstance();
        boolean flag = instance.updateStudentInfo(student);
        if(flag){
            request.getRequestDispatcher("/StudentInfoManageServlet").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
