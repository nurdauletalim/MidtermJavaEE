package kz.iitu.servlet;

import kz.iitu.dao.PostDAO;
import kz.iitu.dao.UserDAO;
import kz.iitu.model.Post;
import kz.iitu.model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();

        UserDAO userDao = new UserDAO();
        PostDAO postDao = new PostDAO();

        try {
            Users user = userDao.checkLogin(username, password);

            String direct = "";

            if (password.equals("admin")) {
                RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
                rd.forward(request,response);
            }
            else if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(30*60);
                List<Post> postList = postDao.GetAllPosts();
                request.setAttribute("postList", postList);
                direct = "Main.jsp";
            } else {
                String message = "Incorrect email or password!";
                out.print(message);
                request.setAttribute("message", message);
                direct = "Login.jsp";
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(direct);
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
