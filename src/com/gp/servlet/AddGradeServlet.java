package com.gp.servlet;

import com.gp.manager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gp
 * @create 2019/12/23 15:55
 */
@WebServlet("/AddGradeServlet")
public class AddGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String studentName = request.getParameter("studentName");
        String className = request.getParameter("className");
        String score = request.getParameter("score");
        UserManager userManager = UserManager.getInstance();
        userManager.addGrade(studentName,className,score);
        request.getRequestDispatcher("/StudentGradeManageServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
