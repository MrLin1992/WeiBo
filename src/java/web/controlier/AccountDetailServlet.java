/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controlier;

import domain.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AccountService;
import service.MessageService;
import service.impl.AccountServiceImpl;
import service.impl.MessageServiceImpl;

/**
 *
 * @author linshangzhen
 */
@WebServlet(name = "AccountDetailServlet", urlPatterns = {"/AccountDetailServlet"})
public class AccountDetailServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userIdString = request.getParameter("user_id");
        long userId = Long.parseLong(userIdString);
        String userName = request.getParameter("user_name");
        Account account = (Account) request.getSession().getAttribute("account");
        long id = account.getId();
        MessageService service = new MessageServiceImpl();
        List list = service.userList(userId);
        request.setAttribute("messageList", list);
        request.setAttribute("user_name", userName);
        request.setAttribute("user_id", userId);
        request.getRequestDispatcher("accountDetail.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
