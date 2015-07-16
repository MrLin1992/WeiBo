/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controlier;

import domain.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.impl.AccountServiceImpl;

/**
 *
 * @author linshangzhen
 */
@WebServlet(name = "LogInServlet", urlPatterns = {"/LogInServlet"})
public class LogInServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        boolean isOK = true;
        Map errors = new HashMap();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (name == null || name.trim().equals("")) {
            isOK = false;
            errors.put("name", "姓名不能为空");
        }
        if (password == null || password.trim().equals("")) {
            isOK = false;
            errors.put("password", "密码不能为空");
        }
        if (!isOK) {
            request.setAttribute("logInErrors", errors);
            request.getRequestDispatcher("logIn.jsp").forward(request, response);
            return;
        }
        AccountServiceImpl service = new AccountServiceImpl();
        Account account = service.login(name, password);
        if (account != null) {
            request.getSession().setAttribute("account", account);
            response.sendRedirect("home.jsp");
            return;
        }
        errors.put("name", "账号或姓名错误！");
        request.setAttribute("logInErrors", errors);
        request.getRequestDispatcher("logIn.jsp").forward(request, response);
        return;

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
