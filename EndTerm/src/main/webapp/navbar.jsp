<html>
<head>
    <style>
        header {
            padding: 156px 0 100px;
        }

        section {
            padding: 150px 0;
        }
    </style>
    </head>
    <jsp:useBean id="user" class="kz.iitu.model.Users" scope="session"/>
    <jsp:setProperty name="user" property="*"/>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top mb-6">
    <a class="navbar-brand" href="#">Phone Store</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="Main.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Phones.jsp">Shop</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="PostsServlet">Posts</a>
            </li>
                        <% if (user.getName() != null) { %>
            <li class="nav-item">
                <a class="nav-link" href="LogoutServlet">Log out</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="NewPost.jsp">New Post</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ProfileServlet">
                                        <jsp:getProperty name="user" property="name"/>
                </a>
            </li>
                        <% }
                            if (user.getName() == null) { %>


            <li class="nav-item">
                <a class="nav-link" href="Login.jsp">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Register.jsp">Register</a>
            </li>
                        <% } %>


        </ul>
    </div>
</nav>
</body>
</html>