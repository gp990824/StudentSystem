package com.gp.servlet;

import com.gp.manager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author gp
 * @create 2019/12/23 15:20
 */
@WebServlet("/QueryTotalClassStudentNameServlet")
public class QueryTotalClassStudentNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        UserManager userManager = UserManager.getInstance();
        List<String> classes = userManager.queryTotalClass();
        List<String> studentsName = userManager.queryTotalStudentName();

        request.setAttribute("className",classes);
        request.setAttribute("studentName",studentsName);
        request.getRequestDispatcher("/addgrade.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
