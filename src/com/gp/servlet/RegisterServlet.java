package com.gp.servlet;

import com.gp.bean.StudentBean;
import com.gp.manager.UserManager;

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
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String radio = request.getParameter("radio");
        String email = request.getParameter("email");
        StudentBean student = new StudentBean(name,password,radio,email);
        UserManager userManager = UserManager.getInstance();
        boolean flag = userManager.addStudent(student);
        if(flag){
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/registererror.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
