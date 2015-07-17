package web.controlier;

import domain.Account;
import domain.Comment;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CommentService;
import service.impl.CommentServiceImpl;

@WebServlet(name = "AddCommentServlet", urlPatterns = {"/AddCommentServlet"})
public class AddCommentServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        CommentService service = new CommentServiceImpl();
        Comment comment = new Comment();
        Account account = (Account) request.getSession().getAttribute("account");
        long accountId = account.getId();
        String messageIdString = request.getParameter("message_id");
        long messageId = Long.parseLong(messageIdString);
        String content = request.getParameter("commentContent");
        comment.setAccountId(accountId);
        comment.setMessageId(messageId);
        comment.setContent(content);
        service.add(comment);
        List list = service.CommentList(messageId);
        request.setAttribute("commentList", list);
        request.getRequestDispatcher("commentList.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
