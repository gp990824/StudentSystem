package com.gp.servlet;

import com.gp.bean.GradeBean;
import com.gp.manager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gp
 * @create 2019/12/23 13:57
 */
@WebServlet("/UpdateGradeServlet")
public class UpdateGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        UserManager userManager = UserManager.getInstance();
        GradeBean gradeBean = userManager.queryGradeByid(id);
        request.setAttribute("user",gradeBean);
        request.getRequestDispatcher("/WEB-INF/jsp/gradeupdate.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
