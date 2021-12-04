<%-- 
    Document   : adminHome
    Created on : May 13, 2021, 10:16:09 AM
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
                </div>
                <!-- /.col-lg-3 -->

                <div class="col-lg-9">
                    <p></p>
                    <div class="text-center">
                        <div class="alert alert-success" role="alert">
                            <h4 class="alert-heading">WELCOME!</h4>
                            <p>This is administrator's page.</p>
                            <hr>
                            <p class="mb-0">You can add new/ update/ delete car here.</p>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-12 col-md-6 mb-4">
                            <div class="form-floating mb-12">
                                <a href="list-car" class="btn btn-success">List Car</a>
                            </div>
                        </div>
                        <div class="col-lg-12 col-md-6 mb-4">
                            <div class="form-floating mb-12">
                                <a href="add-new-car" class="btn btn-warning">Add New Car</a>
                            </div>
                        </div>
                        <div class="col-lg-12 col-md-6 mb-4">
                            <div class="form-floating mb-12">
                                <a href="add-new-category" class="btn btn-info">Add New Category</a>
                            </div>
                        </div>
                        <div class="col-lg-12 col-md-6 mb-4">
                            <div class="form-floating mb-12">
                                <a href="add-new-discount" class="btn btn-dark">Add New Discount</a>
                            </div>
                        </div>
                    </div>

                    <!-- /.row -->

                </div>
                <!-- /.col-lg-9 -->

            </div>
            <!-- /.row -->

        </div>
        <!-- /.container -->

        <!-- Footer -->
<!--        <footer class="py-5 bg-dark" style="position: absolute; left: 0; bottom: 0; text-align: center; width: 100%">
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
