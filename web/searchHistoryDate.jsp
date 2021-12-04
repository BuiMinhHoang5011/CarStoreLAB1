<%-- 
    Document   : searchHistoryDate
    Created on : May 18, 2021, 10:39:15 AM
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
                <form class="form-inline" action="search-history-date">
                    <table>
                        <thead>
                            <tr>
                                <th>From</th>
                                <th>To</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input class="form-control mr-sm-2" type="date" placeholder="Search" aria-label="Search" style="margin-left: 2%" name="from"></td>
                                <td><input class="form-control mr-sm-2" type="date" placeholder="Search" aria-label="Search" style="margin-left: 2%" name="to"></td>
                                <td><button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search By Date</button></td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </nav>
            <table class="table table-striped table-dark">
                <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Create Date</th>
                        <th scope="col">Total Price</th>
                        <th scope="col">Discount Use</th>
                        <th scope="col">Active</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listOrder}" var="O" varStatus="track">
                        <tr>
                            <th>${track.count}</th>
                            <td>${O.createDate}</td>
                            <td>${O.totalPrice}</td>
                            <c:choose>
                                <c:when test="${O.discount == null}">
                                    <td>Not Use Discount</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${O.discount}</td>
                                </c:otherwise>
                            </c:choose>
                            <td><a class="btn btn-success" href="history-detail?orderId=${O.orderId}">Detail>></a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- /.container -->

        <!-- Footer -->
<!--        <footer class="py-5 bg-dark mt-5" style="position: absolute; left: 0; bottom: 0; width: 100%; text-align: center">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
            </div>
             /.container 
        </footer>-->

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>

</html>


