package com.gp.servlet;

import com.gp.manager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author gp
 * @create 2019/12/22 15:51
 */
@WebServlet("/UserDelServlet")
public class UserDelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("UserId"));

        UserManager userMassage=UserManager.getInstance();
        boolean flag = userMassage.delStudent(id);
        if (flag) {
            request.getRequestDispatcher("/StudentInfoManageServlet").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
