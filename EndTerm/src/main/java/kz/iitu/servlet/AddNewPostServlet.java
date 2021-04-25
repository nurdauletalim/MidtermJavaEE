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
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AddNewPostServlet")
public class AddNewPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean status;
        PrintWriter out = response.getWriter();
        String topic = request.getParameter("topic");
        String text = request.getParameter("text");
        try {
            Integer userId = Integer.parseInt(request.getParameter("userId"));
            String post = request.getParameter("post");
            Users user = new UserDAO().getUserById(userId);

            Post newPost = new Post();
            newPost.setTopic(topic);
            newPost.setText(text);
            newPost.setLike(1);
            newPost.setDislike(0);
            newPost.setUserId(userId);
            status = new PostDAO().newPost(newPost);
            if(status){
                out.println("<script>alert('Model.Post successfully added!')</script>");
                request.setAttribute("post", post);
                RequestDispatcher dispatcher =request.getRequestDispatcher("Main.jsp");
                dispatcher.forward(request, response);
            }else{
                out.println("<script>alert('Error ! This kind of post already exists in the base')</script>");
                response.sendRedirect("Main.jsp");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }

}
