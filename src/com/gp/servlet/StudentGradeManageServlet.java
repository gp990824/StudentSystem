package com.gp.servlet;

import com.gp.bean.GradeBean;
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
 * @create 2019/12/22 20:25
 */
@WebServlet("/StudentGradeManageServlet")
public class StudentGradeManageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        UserManager userManager = UserManager.getInstance();
        List<GradeBean> gradeBeans = userManager.queryStudentGrade();
        request.setAttribute("grade",gradeBeans);
        request.getRequestDispatcher("/WEB-INF/jsp/studentgrade.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
