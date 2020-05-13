package com.gp.servlet;

import com.gp.manager.GradeService;
import com.gp.manager.StudentService;
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
 * @create 2019/12/23 15:20
 */
@WebServlet("/QueryAllStudentNameAndClassNamesServlet")
public class QueryAllStudentNameAndClassNamesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        GradeService gradeService = GradeService.getInstance();
        List<String> classes = gradeService.queryAllClasses();
        StudentService studentService = StudentService.getInstance();
        List<String> studentNames = studentService.queryAllStudentName();


        if (classes != null && studentNames != null) {
            request.setAttribute("classes",classes);
            request.setAttribute("studentNames",studentNames);
            request.getRequestDispatcher("/WEB-INF/jsp/addGradeInfo.jsp").forward(request,response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
