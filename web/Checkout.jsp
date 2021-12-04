<%-- 
    Document   : Checkout
    Created on : May 16, 2021, 9:32:29 AM
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
        <div class="container" style="margin-top: 5rem">
            <div class="row">
                <div class="col-md-8" style="border: 1px solid #ced4da;border-radius: 5px !important">
                    <h4 class="mt-3">List of Product</h4>
                    <table class="w-100 table table-striped mt-3">   
                        <tr>
                            <th>STT</th>
                            <th>Image</th>
                            <th>Name of Product</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Total Price</th>
                        </tr>
                        <c:forEach items="${sessionScope.listCart}" var="C" varStatus="track">
                            <tr>
                                <td>${track.count}</td>
                                <td>
                                    <img src="images/${C.carImg}" style="width: 100px">
                                </td>
                                <td>${C.carName}</td>
                                <td>
                                    <fmt:formatNumber type="currency" value="${C.carPrice}"/>
                                </td>
                                <td>
                                    <fmt:formatNumber type="number" value="${C.quantity}"/>                                 
                                </td>
                                <td>
                                    <fmt:formatNumber type="currency" value="${C.carPrice * C.quantity}"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <hr/>
                    <div class="text-right">
                        <h4>Total price:<fmt:formatNumber type="number" value="${total}"/></h4>
                    </div>
                </div>
                <div class="col-md-4 pl-5" style="border: 1px solid #ced4da;border-radius: 5px !important;">
                    <h3 class="mt-3" style="color: orange">Information of Customer</h3>
                    <div class="card mt-3">
                        <div class="card-body">
                           <form action="checkout" method="post">
                                <div class="form-group">
                                    <label for="name">Full Name</label>
                                    <input type="text" name="name" class="form-control" placeholder="Enter name" required>
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                </div>
                                <div class="form-group">
                                    <label for="sdt">Phone number</label>
                                    <input type="number" name="mobile" class="form-control" placeholder="enter phone number" required>
                                </div>
                                <div class="form-group">
                                    <label for="address">Address</label>
                                    <textarea class="form-control" rows="3" name="address" required></textarea>
                                </div><div class="form-group">
                                    <label for="address">Note</label>
                                    <textarea class="form-control" rows="3" name="note"></textarea>
                                </div>
                               <input type="hidden" value="${total}" name ="total"/>
                               <input type="hidden" value="${discount}" name="discount"/>
                                <button type="submit" class="btn btn-success w-100">Accept</button>
                            </form>

                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!-- /.container
        -->

        <!-- Footer -->
<!--        <footer class="py-5 bg-dark mt-5">
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

