package com.gp.servlet;

import com.gp.bean.StudentBean;
import com.gp.manager.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Gp
 * @create 2020/5/12 23:03
 */
@WebServlet("/QueryStudentByNameServlet")
public class QueryStudentByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String studentName = req.getParameter("studentName");
        StudentService instance = StudentService.getInstance();
        StudentBean student = instance.queryStudentByName(studentName);
        req.setAttribute("student", student);
        if (student != null) {
            req.getRequestDispatcher("/WEB-INF/jsp/queryStudentInfo.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/noSuchStudentError.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
