package com.gp.servlet;

import com.gp.bean.GradeBean;
import com.gp.manager.GradeService;

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
@WebServlet("/UpdateGradeScoreByIdServlet")
public class UpdateGradeScoreByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String score = request.getParameter("score");
        GradeBean gradeBean = new GradeBean();
        gradeBean.setId(id);
        gradeBean.setScore(score);
        GradeService instance = GradeService.getInstance();
        boolean flag = instance.updateGradeInfo(gradeBean);
        if (flag) {
            request.getRequestDispatcher("/StudentGradeManageServlet").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
