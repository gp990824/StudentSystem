package com.gp.servlet;

import com.gp.bean.GradeViewBean;
import com.gp.manager.GradeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Gp
 * @create 2020/5/13 10:08
 */
@WebServlet("/QueryGradeByNameServlet")
public class QueryGradeByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String studentName = req.getParameter("studentName");
        GradeService instance = GradeService.getInstance();
        List<GradeViewBean> grades = instance.queryGradeByName(studentName);
        if (grades != null) {
            req.setAttribute("grades", grades);
            req.getRequestDispatcher("/WEB-INF/jsp/queryGradeInfo.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
