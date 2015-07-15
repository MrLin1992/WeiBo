/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controlier;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author linshangzhen
 */
@WebServlet(name = "MessageDetailServlet", urlPatterns = {"/MessageDetailServlet"})
public class MessageDetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String messageIdString = request.getParameter("message_id");
        long messageId = Long.parseLong(messageIdString);
        String content = request.getParameter("message_content");
        String account = request.getParameter("message_account");
        request.setAttribute("message_id", messageId);
        request.setAttribute("message_content", content);
        request.setAttribute("message_account", account);
        
        request.getRequestDispatcher("messageDetail.jsp").forward(request, response);
        
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
