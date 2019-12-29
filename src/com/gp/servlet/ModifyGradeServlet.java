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
 * @create 2019/12/23 14:28
 */
@WebServlet("/ModifyGradeServlet")
public class ModifyGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String stu_name = request.getParameter("stu_name");
        String classname = request.getParameter("classname");
        String score = request.getParameter("score");
        GradeBean gradeBean = new GradeBean(id, stu_name, classname, score);
        UserManager userManager = UserManager.getInstance();
        boolean flag = userManager.updateGrade(gradeBean);
        if(flag){
            request.getRequestDispatcher("/StudentGradeManageServlet").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
