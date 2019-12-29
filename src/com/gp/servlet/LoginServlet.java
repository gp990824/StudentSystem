package com.gp.servlet;

import com.gp.bean.UserBean;
import com.gp.manager.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author gp
 * @create 2019/12/21 23:13
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        UserManager userManager = UserManager.getInstance();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int identity = Integer.parseInt(request.getParameter("identity"));

        HttpSession session = request.getSession();// 获取session对象

        UserBean user = new UserBean(username, password,identity);// 封装用户的的javabean
        boolean flag = userManager.login(user);

        if (flag) {

            session.setAttribute("name", username);
            session.setAttribute("password", password);
            session.setAttribute("shenfen", identity);

            if (identity == 1) {
                request.getRequestDispatcher("/admin.jsp").forward(request, response);
            }

            if (identity == 0) {
                request.getRequestDispatcher("/studentlogin.jsp").forward(request, response);
            }

        } else {
            request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
