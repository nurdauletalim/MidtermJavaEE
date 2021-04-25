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

@WebServlet(name = "PostDetailServlet")
public class PostDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PostDAO postDao = new PostDAO();

        try {
            Integer postId = 0;

            if (req.getParameter("postId") != null) {
                postId = Integer.parseInt(req.getParameter("postId"));
            }
            Post post = postDao.getPostById(postId);

            req.setAttribute("post", post);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("PostDetail.jsp");
            requestDispatcher.forward(req, resp);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
