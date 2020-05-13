package com.gp.servlet;

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
 * @create 2019/12/22 15:51
 */
@WebServlet("/DeleteStudentByIdServlet")
public class DeleteStudentByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("studentId"));

        StudentService instance = StudentService.getInstance();
        boolean flag = instance.delStudentById(id);
        if (flag) {
            request.getRequestDispatcher("/StudentInfoManageServlet").forward(request,response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
