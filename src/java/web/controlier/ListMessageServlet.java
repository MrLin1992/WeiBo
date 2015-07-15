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
import service.MessageService;
import service.impl.MessageServiceImpl;

/**
 *
 * @author linshangzhen
 */
@WebServlet(name = "ListMessageServlet", urlPatterns = {"/ListMessageServlet"})
public class ListMessageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MessageService service = new MessageServiceImpl();
        Account account = (Account) request.getSession().getAttribute("account");
        long id = account.getId();
        List list = service.homeList(id);
        request.setAttribute("messageList", list);
        request.getRequestDispatcher("messageList.jsp").forward(request, response);
        
        
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
