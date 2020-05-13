package com.gp.servlet;

import com.gp.bean.StudentBean;
import com.gp.manager.StudentService;
import com.gp.manager.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gp
 * @create 2019/12/22 15:24
 */
@WebServlet("/QueryStudentByIdServlet")
public class QueryStudentByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));

        StudentService instance = StudentService.getInstance();
        StudentBean student = instance.queryStudentById(id);
        if (student != null) {
            request.setAttribute("user", student);
            request.getRequestDispatcher("/WEB-INF/jsp/updateStudentInfo.jsp").forward(request, response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
