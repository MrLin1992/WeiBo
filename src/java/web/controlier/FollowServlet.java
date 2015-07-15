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
import service.AccountService;
import service.impl.AccountServiceImpl;

@WebServlet(name = "FollowServlet", urlPatterns = {"/FollowServlet"})
public class FollowServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account account = (Account) request.getSession().getAttribute("account");
        long accountId = account.getId();
        AccountService service = new AccountServiceImpl();
        List followeeList = service.followeeList(accountId);
        List followerList = service.followerList(accountId);
         
        request.setAttribute("followee_list", followeeList);
        request.setAttribute("follower_list", followerList);
        request.getRequestDispatcher("followDetail.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
