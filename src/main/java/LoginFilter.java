import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html");
            PrintWriter out = servletResponse.getWriter();

            String n=servletRequest.getParameter("email");
            String p=servletRequest.getParameter("password");

            if(p.equals("admin")){
                filterChain.doFilter(servletRequest, servletResponse);
            }
            else if(UserDAO.validate(n, p)){
                RequestDispatcher rd=servletRequest.getRequestDispatcher("Main.jsp");
                rd.forward(servletRequest,servletResponse);
            }
            else{
                out.print("Sorry username or password error");
                RequestDispatcher rd=servletRequest.getRequestDispatcher("Login.jsp");
                rd.include(servletRequest,servletResponse);
            }
        }


    @Override
    public void destroy() {

    }
}

