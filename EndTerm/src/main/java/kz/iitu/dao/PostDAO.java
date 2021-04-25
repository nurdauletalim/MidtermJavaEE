package kz.iitu.dao;

import kz.iitu.model.Comment;
import kz.iitu.model.Post;
import kz.iitu.model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/PhoneStore";
        String dbUser = "postgres";
        String dbPassword = "123";

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

        return connection;
    }


    public List<Post> GetAllPosts()
            throws SQLException, ClassNotFoundException {
        List<Post> posts = new ArrayList<>();
        UserDAO userDao = new UserDAO();
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM posts");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("postid");
            String topic = rs.getString("topic");
            String text = rs.getString("text");
            int likes = rs.getInt("likes");
            int dislikes = rs.getInt("dislikes");
            int userId = rs.getInt("userid");
            Users user = userDao.getUserById(userId);

            Post post = new Post(id,likes,dislikes,userId,topic,text,user);

            posts.add(post);
        }

        rs.close();
        ps.close();
        con.close();

        return posts;
    }

    public boolean newPost(Post post) {
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO posts (topic, text, likes, dislikes, userid) " +
                    "VALUES (?, ?, ?, ?, ?)");

            ps.setString(1, post.getTopic());
            ps.setString(2, post.getText());
            ps.setInt(3, post.getLike());
            ps.setInt(4, post.getDislike());
            ps.setInt(5,post.getUserId());

            ps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public Post getPostById(Integer id) throws SQLException, ClassNotFoundException {
        UserDAO userDao = new UserDAO();
        Connection con = getConnection();

        Post post = new Post();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM posts WHERE postid = ? LIMIT 1");
        ps.setInt(1, id);
        ResultSet resultSet = ps.executeQuery();
        resultSet.next();

        post.setUserId(resultSet.getInt("userid"));
        post.setText(resultSet.getString("text"));
        post.setTopic(resultSet.getString("topic"));
        post.setLike(resultSet.getInt("likes"));
        post.setDislike(resultSet.getInt("dislikes"));
        post.setUser(userDao.getUserById(resultSet.getInt("userid")));
        post.setId(id);
        post.setComments(getAllByPostId(id));

        return post;
    }
        public boolean like(Post post) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement("UPDATE posts SET likes = ?,dislikes = ? WHERE postid = ?");
        ps.setInt(1, post.getLike());
        ps.setInt(2, post.getDislike());
        ps.setInt(3, post.getId());

        boolean liked = ps.executeUpdate() > 0;
        ps.close();
        con.close();

        return liked;
    }




    public List<Comment> getAllByPostId(Integer pId) throws SQLException, ClassNotFoundException {
        List<Comment> comments = new ArrayList<>();
        UserDAO userDao = new UserDAO();

        Connection con = getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM comments WHERE postid = ?");
        ps.setInt(1, pId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Integer id = rs.getInt("id");
            Integer postId = rs.getInt("postid");
            Integer userId = rs.getInt("userid");
            String comment = rs.getString("comment");

            Users user = userDao.getUserById(userId);


            Comment com = new Comment(id, postId, userId, comment, user);

            comments.add(com);
        }

        return comments;
    }

    public int newComment(Comment comment) {
        int res = 0;

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO comments (postid, userid, comment) " +
                    "VALUES (?, ?, ?)");

            ps.setInt(1, comment.getPostId());
            ps.setInt(2, comment.getUserId());
            ps.setString(3, comment.getComment());

            res = ps.executeUpdate();

            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return res;
    }


    public Comment getCommentById(Integer id) throws SQLException, ClassNotFoundException {

        UserDAO userDao = new UserDAO();

        Connection con = getConnection();

        Comment com = new Comment();

        PreparedStatement ps = con.prepareStatement("SELECT * FROM comments WHERE id = ? LIMIT 1");
        ps.setInt(1, id);

        ResultSet resultSet = ps.executeQuery();
        resultSet.next();

        com.setId(id);
        com.setPostId(resultSet.getInt("postid"));
        com.setComment(resultSet.getString("comment"));
        com.setUserId(resultSet.getInt("userid"));

        return com;
    }
}
