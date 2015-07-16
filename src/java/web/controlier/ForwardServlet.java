package web.controlier;

import domain.Account;
import domain.Message;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MessageService;
import service.impl.MessageServiceImpl;

@WebServlet(name = "ForwardServlet", urlPatterns = {"/ForwardServlet"})
public class ForwardServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Account account = (Account) request.getSession().getAttribute("account");
        long accountId = account.getId();
        String content = request.getParameter("message_content");
        String messageIdString = request.getParameter("message_id");
        long messageId = Long.parseLong(messageIdString);
        Message message = new Message();
        message.setAccountId(accountId);
        message.setContent(content);
        message.setForwardMessageId(messageId);
        MessageService service = new MessageServiceImpl();
        service.forward(message);
        response.sendRedirect("home.jsp");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

    