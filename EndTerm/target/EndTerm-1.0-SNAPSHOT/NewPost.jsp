<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>New Post</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>

<body id="page-top">

<!-- Navigation -->
<%@ include file="/navbar.jsp" %>
<header class="bg-primary text-white">
    <div class="container text-center">
        <h1>Add new Post</h1>
    </div>
</header>

<section id="about">
    <div class="container">
        <div class="row">
            <form action="AddNewPostServlet" method="post">
                <div class="form-group">
                    <label for="exampleInputEmail1">Theme of post</label>
                    <input type="hidden" name="userId" value="<%=user.getId()%>">
                    <input type="text" class="form-control" id="exampleInputEmail1" name="topic">
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Text</label>
                    <input type="hidden" name="userId" value="<%=user.getId()%>">
                    <input type="text" class="form-control" id="exampleInputPassword1" name="text">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</section>


<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Alim N 2021</p>
    </div>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom JavaScript for this theme -->
<script src="js/scrolling-nav.js"></script>

</body>
</html>
