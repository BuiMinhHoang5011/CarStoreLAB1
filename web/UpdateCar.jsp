<%-- 
    Document   : UpdateCar
    Created on : May 21, 2021, 11:06:46 AM
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
                    <div class="text-center">
                        <img src="images/admin.jpg" class="rounded" alt="...">
                        <a href="list-car" class="btn btn-danger" style="width: 90%; border-radius: 15px"><i class="fas fa-backward"></i>  Back</a>
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
                            <p class="mb-0">You can update car here.</p>
                        </div>
                    </div>

                    <div class="row">
                        <h3 style="width: 100%; text-align: center; margin-bottom: 5%">Update Car</h3>

                        <div class="col-lg-6">

                            <form action="update-car" method="post">
                                <input type="hidden" value="${carId}" name="carId">
                                <div class="form-group">
                                    <label for="exampleInputUsername1" style="color: blue">Category Name :</label>
                                    <select name="category" style="width: 68%">
                                        <c:forEach items="${listCategory}" var="C">      
                                            <option value="${C.category_id}"<c:if test="${C.category_id == car.category_id}">selected="C.category_id"</c:if>>${C.categoryName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputUsername1" style="color: red">Car Name</label>
                                    <input name="carname" type="text" class="form-control" id="exampleInputUsername1" aria-describedby="emailHelp" required value="${car.car_name}">
                                    <small id="emailHelp" class="form-text text-muted">Please Input Car Name</small>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1" style="color: red">Quantity</label>
                                    <input min="0" name="quantity" type="number" class="form-control" id="exampleInputPassword1" required value="${car.quantity}">
                                    <small id="emailHelp" class="form-text text-muted">Please Input Quantity</small>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputUsername1" style="color: red">Price</label>
                                    <input min="0" name="price" type="number" class="form-control" id="exampleInputUsername1" aria-describedby="emailHelp" required value="${car.price}">
                                    <small id="emailHelp" class="form-text text-muted">Please Input Price</small>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputUsername1" style="color: red">Description</label>
                                    <textarea name="description" rows="10" cols="20" name="description" class="form-control" id="exampleInputUsername1" aria-describedby="emailHelp" required>${car.description}
                                    </textarea>

                                    <small id="emailHelp" class="form-text text-muted">Your Description</small>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1" style="color: red">Color</label>
                                    <input name="color" type="text" class="form-control" id="exampleInputEmail1" required value="${car.color}">
                                    <small id="emailHelp" class="form-text text-muted">Please Input Color</small>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPhone1" style="color: red">Image Link</label>
                                    <input name="image" type="text" class="form-control" id="exampleInputPhone1" required value="${car.image}">
                                    <small id="emailHelp" class="form-text text-muted">Please Input Image Link</small>
                                </div>
                                    <h5 style="color: red">${errImg}</h5>
                                <div class="form-group">
                                    <label for="exampleInputUsername1" style="color: blue">Status :</label>
                                    <select name="status" style="width: 68%">
                                        <c:choose>
                                            <c:when test="${car.status == 1}">
                                                <option value="1">Available</option>
                                                <option value="0">Not Ready Yet</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="0">Not Ready Yet</option>
                                                <option value="1">Available</option>                                               
                                            </c:otherwise>
                                        </c:choose>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-primary">Update Car</button>

                            </form>
                        </div>
                        <div class="col-lg-3"><h3>${err}</h3></div>
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

