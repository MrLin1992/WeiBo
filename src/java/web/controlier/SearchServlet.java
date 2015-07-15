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
import service.AccountService;
import service.impl.AccountServiceImpl;

/**
 *
 * @author linshangzhen
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountService service = new AccountServiceImpl();
        String name = request.getParameter("search");
        String errors = null;
        if(name == null || name.trim().equals("")){
            errors = "输入为空！";
            request.setAttribute("errorMessage", errors);
            request.getRequestDispatcher("searchResult.jsp").forward(request, response); 
            return ;
        }
        List list = service.search(name);
        if(list.isEmpty()){
            errors = "查无此人！";
            request.setAttribute("errorMessage", errors);
            request.getRequestDispatcher("searchResult.jsp").forward(request, response); 
            return ;           
        }
        request.setAttribute("searchResult", list);
        request.getRequestDispatcher("searchResult.jsp").forward(request, response);   
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
