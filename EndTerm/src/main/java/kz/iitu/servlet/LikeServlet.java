package kz.iitu.servlet;

import kz.iitu.dao.PostDAO;
import kz.iitu.model.Comment;
import kz.iitu.model.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LikeServlet")
public class LikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostDAO postDao = new PostDAO();

        Boolean isLiked = Boolean.valueOf(req.getParameter("like"));
        Boolean isDisLiked = Boolean.valueOf(req.getParameter("dislike"));
        Integer postid = Integer.parseInt(req.getParameter("id"));

        try {
            Post post = postDao.getPostById(postid);
            if (isLiked){
                post.setLike(post.getLike() + 1);
                postDao.like(post);}
            if (isDisLiked){
                post.setDislike(post.getDislike() + 1);
                postDao.like(post);
            }

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("PostDetail.jsp");
            requestDispatcher.forward(req, resp);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
