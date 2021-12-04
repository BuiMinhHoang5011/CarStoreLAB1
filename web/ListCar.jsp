<%-- 
    Document   : ListCar
    Created on : May 20, 2021, 3:45:44 PM
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
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    </head>

    <body>

        <!-- Navigation -->
        <%@include file="NavBar.jsp" %>

        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <div class="col-lg-3">
                </div>
                <!-- /.col-lg-3 -->

                <div class="col-lg-12">
                    <p></p>
                    <div class="text-center">
                        <div class="alert alert-warning" role="alert">
                            <h4 class="alert-heading">WELCOME!</h4>
                            <p>This is administrator's page.</p>
                            <hr>
                            <p class="mb-0">You can view/ update/ delete car here.</p>
                        </div>
                    </div>

                    <div class="row">
                        <table class="table table-bordered table-dark">
                            <thead>
                                <tr>
                                    <th scope="col">Car ID</th>
                                    <th scope="col">Category</th>
                                    <th scope="col">Car Name</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Description</th>
                                    <th scope="col">Color</th>
                                    <th scope="col">Image</th>
                                    <th scope="col">Create Date</th>
                                    <th scope="col">Status</th>
                                    <th scope="col" colspan="2">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listCar}" var="B">
                                    <tr>
                                        <th scope="row">${B.carId}</th>
                                            <c:forEach items="${listCategory}" var="C">
                                                <c:if test="${B.category_id == C.category_id}">
                                                <td style="color: red">${C.categoryName}</td>
                                            </c:if>
                                        </c:forEach>
                                        <td style="color: yellow">${B.car_name}</td>
                                        <td>${B.quantity}</td>
                                        <td>${B.price}</td>
                                        <td><textarea name="" rows="4" cols="20" disabled="true">${B.description}</textarea></td>
                                        <td>${B.color}</td>
                                        <td><img src="images/${B.image}" width="auto" height="130px"></td>
                                        <td>${B.create_date}</td>
                                        <c:choose>
                                            <c:when test="${B.status == 1}">
                                                <td style="color: palegreen">Available</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td style="color: plum">Not Ready Yet</td>
                                            </c:otherwise>
                                        </c:choose>                                      
                                        <td><a href="delete-car?carId=${B.carId}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this car')"><i class="fas fa-trash"></i></a></td>
                                        <td><a href="update-car?carId=${B.carId}" class="btn btn-warning">Update</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>

                    <!-- /.row -->

                </div>
                <!-- /.col-lg-9 -->

            </div>
            <!-- /.row -->

        </div>
        <!-- /.container -->

        <!-- Footer -->
<!--        <footer class="py-5 bg-dark">
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

