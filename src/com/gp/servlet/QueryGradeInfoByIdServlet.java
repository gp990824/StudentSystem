package com.gp.servlet;

import com.gp.bean.GradeBean;
import com.gp.bean.GradeViewBean;
import com.gp.manager.GradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Gp
 * @create 2020/5/13 9:32
 */
@WebServlet("/QueryGradeInfoByIdServlet")
public class QueryGradeInfoByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        GradeService instance = GradeService.getInstance();
        GradeViewBean gradeBean = instance.queryGradeById(id);
        if (gradeBean != null) {
            req.setAttribute("grade", gradeBean);
            req.getRequestDispatcher("/WEB-INF/jsp/updateGradeInfo.jsp").forward(req, resp);
        }
    }
}
