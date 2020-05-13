package com.gp.servlet;

import com.gp.bean.GradeViewBean;
import com.gp.manager.GradeService;
import com.gp.manager.UserService;

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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String studentName = request.getParameter("studentName");
        String className = request.getParameter("className");
        String score = request.getParameter("score");
        if("请选择".equals(studentName) || "请选择".equals(className)){
            response.sendRedirect("/StudentGradeManageServlet");
            throw new RuntimeException("下拉选项出错, 请选择正确的值!");
        }
        GradeViewBean gradeViewBean = new GradeViewBean();
        gradeViewBean.setScore(score);
        gradeViewBean.setClassName(className);
        gradeViewBean.setStudentName(studentName);

        GradeService instance = GradeService.getInstance();
        boolean flag = instance.addGrade(gradeViewBean);
        if (flag){
            request.getRequestDispatcher("/StudentGradeManageServlet").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
