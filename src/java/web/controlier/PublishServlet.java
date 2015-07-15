/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controlier;

import domain.Account;
import domain.Message;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MessageService;
import service.impl.MessageServiceImpl;

/**
 *
 * @author linshangzhen
 */
@WebServlet(name = "PublishServlet", urlPatterns = {"/PublishServlet"})
public class PublishServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String content = request.getParameter("messageContent");

        Message message = new Message();
        Account account = (Account) request.getSession().getAttribute("account");
        long accountId = account.getId();
        message.setAccountId(accountId);
        message.setContent(content);
        MessageService service = new MessageServiceImpl();
        service.publish(message);
        
        List list = service.homeList(accountId);
        request.setAttribute("messageList", list);
        request.getRequestDispatcher("messageList.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
