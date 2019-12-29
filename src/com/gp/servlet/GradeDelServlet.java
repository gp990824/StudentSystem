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
 * @create 2019/12/22 21:46
 */
@WebServlet("/GradeDelServlet")
public class GradeDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int score = Integer.parseInt(request.getParameter("id"));
        UserManager userManager = UserManager.getInstance();
        boolean flag = userManager.deleteGrade(score);
        if(flag){
            request.getRequestDispatcher("/StudentGradeManageServlet").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
