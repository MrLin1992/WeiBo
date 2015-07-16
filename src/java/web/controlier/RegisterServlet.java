package web.controlier;

import domain.Account;
import exception.AccountExistException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.AccountService;
import service.impl.AccountServiceImpl;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        boolean isOK = true;
        Map errors = new HashMap();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        if(name == null || name.trim().equals("")){
            isOK = false;
            errors.put("name","姓名不能为空！");
        }
        
        if(password == null || password.trim().equals("")){
            isOK = false;
            errors.put("password","密码不能为空");
        }
        
        if(email == null || email.trim().equals("")){
            isOK = false;
            errors.put("email","邮箱不能为空");
        }
        
        if(password1 == null || password1.trim().equals("")){
            isOK = false;
            errors.put("password1","确认密码不能为空！");
        }else{
            if(!password.equals(password1)) {
                isOK = false;
                errors.put("password1", "两次密码不一致！");    
            }
        }
        if(!isOK){
            request.setAttribute("registerErrors", errors);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return ;    
        }
        
        Account account = new Account();
        account.setName(name);
        account.setEmail(email);
        account.setPassword(password);
        AccountService service = new AccountServiceImpl();
        try{
            service.register(account);
            response.sendRedirect("logIn.jsp");     
            
        }catch(AccountExistException e){
            errors.put("name", "账号已存在！");
            request.setAttribute("registerErrors", errors);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return ;
        }   
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
