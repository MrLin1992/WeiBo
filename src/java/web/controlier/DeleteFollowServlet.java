/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controlier;

import domain.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AccountService;
import service.impl.AccountServiceImpl;

/**
 *
 * @author linshangzhen
 */
@WebServlet(name = "DeleteFollowServlet", urlPatterns = {"/DeleteFollowServlet"})
public class DeleteFollowServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Account account = (Account) request.getSession().getAttribute("account");
        long follower = account.getId();
        String followeeString = request.getParameter("user_id");
        long followee = Long.parseLong(followeeString);
        AccountService service = new AccountServiceImpl();
        service.deleteFollow(follower, followee);

        request.setAttribute("is_followed", false);
        request.setAttribute("user_id", followee);
        request.getRequestDispatcher("followButton.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
