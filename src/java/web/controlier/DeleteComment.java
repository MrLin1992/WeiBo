package web.controlier;

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

@WebServlet(name = "DeleteComment", urlPatterns = {"/DeleteComment"})
public class DeleteComment extends HttpServlet {
    
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commentIdString = request.getParameter("comment_id");
        long commentId = Long.parseLong(commentIdString);
        String messageIdString = request.getParameter("message_id");
        long messageId = Long.parseLong(messageIdString);
        
        CommentService service = new CommentServiceImpl();
        service.delete(commentId);
        System.out.println("+++++++++++++++++"+messageId);
        List list = service.CommentList(messageId);
        request.setAttribute("commentList", list);
        request.getRequestDispatcher("commentList.jsp").forward(request, response);
        
        
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
