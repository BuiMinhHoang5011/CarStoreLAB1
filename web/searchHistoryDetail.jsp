<%-- 
    Document   : searchHistoryDetail
    Created on : May 18, 2021, 2:14:16 PM
    Author     : Hoang
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    </head>

    <body>

        <!-- Navigation -->
        <%@include file="NavBar.jsp" %>

        <!--container-->
        <div class="container" style="margin-top: 7rem;margin-bottom: 7rem">
            
            <nav class="navbar navbar-light bg-light">
                <a href="history" class="btn btn-danger">Back</a>
                <form class="form-inline" action="search-history-detail">
                    <table>
                        <thead>
                            <tr>
                                <th>Search By Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="name"></td>
                                 <input type="hidden" value="${orderId}" name="orderId">
                                <td><button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button></td>

                            </tr>
                        </tbody>
                    </table>   
                </form>
                <!--searching 2-->

                <!--searching 2-->
            </nav>
            <table class="table table-striped table-dark">
                <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Product Name</th>
                        <th scope="col">Product Price</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Product Images</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOrderDetail}" var="OD" varStatus="track">
                        <tr>
                            <th>${track.count}</th>
                            <td>${OD.product_name}</td>
                            <td>${OD.product_price}</td>
                            <td>${OD.quantity}</td>
                            <td><img src="images/${OD.product_image}" style="width: 100px"></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- /.container -->

        <!-- Footer -->
<!--        <footer class="py-5 bg-dark mt-5">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; HoangSE141126 </p>
            </div>
             /.container 
        </footer>-->

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>

</html>

