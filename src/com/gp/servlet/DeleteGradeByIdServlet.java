package com.gp.servlet;

import com.gp.manager.GradeService;
import com.gp.manager.UserService;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gp
 * @create 2019/12/22 21:46
 */
@WebServlet("/DeleteGradeByIdServlet")
public class DeleteGradeByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int score = Integer.parseInt(request.getParameter("id"));
        GradeService instance = GradeService.getInstance();
        boolean flag = instance.deleteGradeById(score);
        if (flag) {
            request.getRequestDispatcher("/StudentGradeManageServlet").forward(request,response);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }
}
