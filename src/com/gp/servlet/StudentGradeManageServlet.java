package com.gp.servlet;

import com.gp.bean.GradeBean;
import com.gp.bean.GradeViewBean;
import com.gp.dao.GradeDAO;
import com.gp.manager.GradeService;
import com.gp.manager.UserService;

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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        GradeService instance = GradeService.getInstance();
        List<GradeViewBean> grades = instance.queryAllStudentGrade();
        if (grades != null) {
            request.setAttribute("grade",grades);
            request.getRequestDispatcher("/WEB-INF/jsp/studentGradeInfo.jsp").forward(request,response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);

    }
}
