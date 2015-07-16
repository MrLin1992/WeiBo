/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author linshangzhen
 */
@WebServlet(name = "ListCommentServlet", urlPatterns = {"/ListCommentServlet"})
public class ListCommentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String messageIdString = request.getParameter("message_id");

        long messageId = Long.parseLong(messageIdString);
        CommentService service = new CommentServiceImpl();
        List list = service.CommentList(messageId);
        request.setAttribute("commentList", list);
        request.getRequestDispatcher("commentList.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
