<%-- 
    Document   : AddNewCategory
    Created on : May 22, 2021, 2:58:36 PM
    Author     : Hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Shop Homepage - Start Bootstrap Template</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/shop-homepage.css" rel="stylesheet">

    </head>

    <body>

        <!-- Navigation -->
        <%@include file="NavBar.jsp" %>

        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <div class="col-lg-3">
                    <div class="text-center">
                        <img src="images/admin.jpg" class="rounded" alt="...">
                    </div>
                    <div class="btn-group dropleft" style="width: 100%">
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Category In System
                        </button>
                        <div class="dropdown-menu">
                            <!-- Dropdown menu links -->
                            <c:forEach items="${listCategory}" var="C">
                                <a class="dropdown-item">${C.categoryName}</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <!-- /.col-lg-3 -->

                <div class="col-lg-9">
                    <p></p>
                    <div class="text-center">
                        <div class="alert alert-success" role="alert">
                            <h4 class="alert-heading">WELCOME!</h4>
                            <p>This is administrator's page.</p>
                            <hr>
                            <p class="mb-0">You can add new category here.</p>
                        </div>
                    </div>

                    <div class="row">
                        
                        <h3 style="width: 100%; text-align: center; margin-bottom: 5%; margin-top: 5%">Add New Category</h3>

                        <div class="col-lg-6">

                            <form action="add-new-category" method="post">

                                <div class="form-group">
                                    <h5 for="exampleInputPhone1" style="color: red">Category Name</h5>
                                    <input name="category" type="text" class="form-control" id="exampleInputPhone1" required>
                                    <small id="emailHelp" class="form-text text-muted">Please Input Category Name</small>
                                </div>
                                <button type="submit" class="btn btn-primary">Add New</button>

                            </form>
                        </div>
                        <div class="col-lg-6">


                        </div>
                    </div>
                    <div class="col-lg-6">
                        <h3 style="color: red">${err}</h3>
                        <h3 style="color: green">${success}</h3>
                        <h3 style="color: red">${error}</h3>
                    </div>
                </div>
                <p></p>

                <!-- /.row -->

            </div>
            <!-- /.col-lg-9 -->

        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
<!--    <footer class="py-5 bg-dark" style="width: 100%; position: absolute; left: 0; bottom: 0">
        <div class="container">
            <p class="m-0 text-center text-white">Copyright &copy; HoangSE141126</p>
        </div>
         /.container 
    </footer>-->

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>

