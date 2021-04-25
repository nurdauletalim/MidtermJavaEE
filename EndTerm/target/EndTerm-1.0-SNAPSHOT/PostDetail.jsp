<%@ page import="java.util.List" %>
<%@ page import="kz.iitu.model.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Post Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <style>body{margin-top:20px;}

    /*==================================================
      Post Contents CSS
      ==================================================*/

    .post-content{
        background: #f8f8f8;
        border-radius: 4px;
        width: 100%;
        border: 1px solid #f1f2f2;
        margin-bottom: 20px;
        overflow: hidden;
        position: relative;
    }

    .post-content img.post-image, video.post-video, .google-maps{
        width: 100%;
        height: auto;
    }

    .post-content .google-maps .map{
        height: 300px;
    }

    .post-content .post-container{
        padding: 20px;
    }

    .post-content .post-container .post-detail{
        margin-left: 65px;
        position: relative;
    }

    .post-content .post-container .post-detail .post-text{
        line-height: 24px;
        margin: 0;
    }

    .post-content .post-container .post-detail .reaction{
        position: absolute;
        right: 0;
        top: 0;
    }

    .post-content .post-container .post-detail .post-comment{
        display: inline-flex;
        margin: 10px auto;
        width: 100%;
    }

    .post-content .post-container .post-detail .post-comment img.profile-photo-sm{
        margin-right: 10px;
    }

    .post-content .post-container .post-detail .post-comment .form-control{
        height: 30px;
        border: 1px solid #ccc;
        box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
        margin: 7px 0;
        min-width: 0;
    }

    img.profile-photo-md {
        height: 50px;
        width: 50px;
        border-radius: 50%;
    }

    img.profile-photo-sm {
        height: 40px;
        width: 40px;
        border-radius: 50%;
    }

    .text-green {
        color: #8dc63f;
    }

    .text-red {
        color: #ef4136;
    }

    .following {
        color: #8dc63f;
        font-size: 12px;
        margin-left: 20px;
    }
    </style>
    <jsp:useBean id="post" class="kz.iitu.model.Post" scope="request"/>
    <jsp:setProperty name="post" property="*"/>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container mt-6" style="margin-bottom: 150px">
    <div class="row">
        <div class="col-md-8">
            <div class="post-content" style="padding: 50px">
                <div class="post-container">
                    <img src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="user" class="profile-photo-md pull-left">
                    <div class="post-detail">
                        <div class="user-info">
                            <h5><a href="#" class="profile-link"><%=post.getUser().getName()%></a> <span class="following">following</span></h5>
                            <p class="text-muted"><%=post.getTopic()%></p>
                        </div>
                        <% if (user.getName() != null) { %>
                        <form action="LikeServlet" method="GET">
                            <div class="reaction">
                                <input type="hidden" name="id" value="<%=post.getId()%>">
                                <button type="submit" class="btn btn-outline-success" name="like" value="true"><i class="fa fa-thumbs-up"></i> <%=post.getLike()%></button>
                                <button type="submit" class="btn btn-outline-danger" name="dislike" value="true"><i class="fa fa-thumbs-down"></i> <%=post.getDislike()%></button>
                            </div>
                        </form>
                        <% } %>
                        <% if (user.getName() == null) { %>
                        <form action="LikeServlet" method="get">
                            <div class="reaction">
                                <a type="submit" href="Login.jsp" class="btn btn-outline-success"><i class="fa fa-thumbs-up"><%=post.getLike()%></i> </a>
                                <a type="submit" href="Login.jsp" class="btn btn-outline-danger"><i class="fa fa-thumbs-down"><%=post.getDislike()%></i> </a>
                            </div>
                        </form>
                        <% } %>
                        <div class="line-divider"></div>
                        <div class="post-text">
                            <p><%=post.getText()%></p>
                        </div>
                        <% for (Comment comment: post.getComments()) { %>
                        <div class="line-divider"></div>
                        <div class="post-comment">
                            <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="" class="profile-photo-sm">
                            <p><a href="#" class="profile-link"><%=comment.getUser().getName()%> </a><i class="em em-laughing"></i> <%=comment.getComment()%> </p>
                        </div>
                        <% } %>
                        <% if (user.getName() != null) { %>
                        <form action="CommentServlet" method="post">
                        <div class="post-comment">
                            <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="" class="profile-photo-sm">
                            <input type="hidden" name="postId" value="<%=post.getId()%>">
                            <input type="hidden" name="userId" value="<%=user.getId()%>">
                            <input type="text" class="form-control" name="comment" placeholder="Post a comment"> <br>
                            <button type="submit" class="btn btn-secondary">Send</button>
                        </div>
                        </form>
                        <%}%>
                        <% if (user.getName() == null) { %>
                        <div class="post-comment">
                            <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="" class="profile-photo-sm">
                            <input type="text" class="form-control" name="comment" placeholder="Post a comment" readonly> <br>
                        </div>
                        <%}%>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Alim N 2021</p>
    </div>
    <!-- /.container -->
</footer>
</body>
</html>

