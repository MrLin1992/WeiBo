package filter;

import domain.Account;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "NewFilter", urlPatterns = {"/*"})
public class NewFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        System.out.println(req.getRequestURI());

        Account account = (Account) req.getSession().getAttribute("account");

        if (account == null) {
            String uri = req.getRequestURI();
            if (uri.equals("/weibo/index.html") || uri.equals("/weibo/logIn.jsp") || uri.equals("/weibo/register.jsp")||uri.contains("LogInServlet")||uri.contains("RegisterServlet")) {
                chain.doFilter(request, response);
            }else{
                  res.sendRedirect("index.html");
            }
        } else {

            chain.doFilter(request, response);
        }

    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    }

}
