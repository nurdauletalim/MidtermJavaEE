package kz.iitu.servlet;

import kz.iitu.dao.PostDAO;
import kz.iitu.dao.UserDAO;
import kz.iitu.model.Comment;
import kz.iitu.model.Post;
import kz.iitu.model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CommentServlet")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDAO userDao = new UserDAO();
        PostDAO postDao = new PostDAO();

        try {
            Integer postId = Integer.parseInt(request.getParameter("postId"));
            Integer userId = Integer.parseInt(request.getParameter("userId"));
            String com = request.getParameter("comment");
            Users user = userDao.getUserById(userId);

            Comment comment = new Comment();
            comment.setComment(com);
            comment.setUserId(userId);
            comment.setPostId(postId);
            comment.setUser(user);

            int res = 0;
            if (com != null) {
                res = postDao.newComment(comment);
            }

            Post post = postDao.getPostById(postId);

            request.setAttribute("post", post);

            System.out.println(res);
            RequestDispatcher dispatcher =request.getRequestDispatcher("PostDetail.jsp");
            dispatcher.forward(request, response);


        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
