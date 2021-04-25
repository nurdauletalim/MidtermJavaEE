package kz.iitu.servlet;

import kz.iitu.dao.PostDAO;
import kz.iitu.model.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PostsServlet")
public class PostsServlet extends HttpServlet {

    public PostsServlet() {super();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostDAO postDAO = new PostDAO();
        try {
            List<Post> postList = postDAO.GetAllPosts();
            request.setAttribute("postList", postList);

            RequestDispatcher dispatcher = request.getRequestDispatcher("Posts.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
