<%-- 
    Document   : Cart
    Created on : May 13, 2021, 7:12:44 PM
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

            <c:choose>
                <c:when test="${listCart == null || listCart.size() == 0}">
                    <div class="alert alert-success" role="alert">
                        <h4 class="alert-heading">ALERT!</h4>
                        <p>Your Cart is empty</p>
                        <hr>
                        <p class="mb-0">Please buy something before comeback</p>
                    </div>
                    <a href="home" class="btn btn-danger">Back Home Page</a>


                </c:when>
                <c:otherwise>
                    <div class="mt-3">
                        <h4>Giỏ hàng</h4>
                        <form id="formQuantity" action="update-cart" method="get">

                            <table class="w-100 table table-striped mt-3">
                                <thead>
                                    <tr><th>STT</th>
                                        <th>Image</th>
                                        <th>Name of Product</th>
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Total Price</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listCart}" var="C" varStatus="track">
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
                                                <input type="number" min="1" value="${C.quantity}" class="pl-1" style="width: 60px" name="quantity${track.count-1}"/>
                                            </td>
                                            <td>
                                                <fmt:formatNumber type="currency" value="${C.carPrice * C.quantity}"/>
                                            </td>
                                            <td>
                                                <a href="delete-cart?carId=${C.carId}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this car from your cart')" ><i class="fas fa-trash"></i></a>
                                            </td>
                                        </tr>                            
                                    </c:forEach>
                                <h5 style="color: red">${alert1}</h5>
                                <h5 style="color: yellowgreen">${alert2}</h5>
                                </tbody>

                            </table>
                            <hr/>
                            <div class="text-right">
                                <h4>Tổng tiền: $<fmt:formatNumber type="number" value="${total}"/></h4>
                            </div>
                            <hr/>
                            <div class="text-right">
                                <a href="delete-cart?deleteAll=1" class="btn btn-danger" onclick="return confirm('Are you sure you want to remove all car from your cart')" ><i class="fas fa-trash mr-2"></i>Delete Cart</a>

                                <button type="submit" class="btn btn-info ml-2"><i class="fas fa-sync-alt mr-2"></i>Update Cart</button>
                                <c:choose>
                                    <c:when test="${checkAmount != null}">
                                        <a href="check-amount" class="btn btn-success ml-2">Continue
                                            <i class="fas fa-arrow-right ml-2"></i>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="checkout?total=${total}&discount=${discount}" class="btn btn-success ml-2">Continue
                                            <i class="fas fa-arrow-right ml-2"></i>
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </form>
                    </div>
                                <p style="color: red">${errorDiscount}</p>
                    <form action="check-discount">
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <input type="hidden" name="total" value="${total}">
                                <input class="btn btn-outline-secondary" type="submit" value="Discount">
                            </div>
                            <input type="text" class="form-control" placeholder="" aria-label="" aria-describedby="basic-addon1" name="discount"> 
                        </div>
                    </form>      
                </c:otherwise>
            </c:choose>
            <!--Discount-->

            <!--Discount-->
        </div>
    </div>
    <!-- /.container -->

    <!-- Footer -->
<!--    <footer class="py-5 bg-dark mt-5" >
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
