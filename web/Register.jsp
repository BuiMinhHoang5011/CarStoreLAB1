<%-- 
    Document   : login.jsp
    Created on : May 11, 2021, 10:43:59 AM
    Author     : Hoang
--%>

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

    </head>

    <body>


        <!-- Page Content -->
        <div class="container">

            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6">
                    <form action="register" method="post">
                        <h3>Register Form</h3>
                        <div class="form-group">
                            <label for="exampleInputUsername1">Username</label>
                            <input name="username" type="text" class="form-control" id="exampleInputUsername1" aria-describedby="emailHelp" required>
                            <small id="emailHelp" class="form-text text-muted">We'll never share your username with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input name="password" type="password" class="form-control" id="exampleInputPassword1" required>
                            <small id="emailHelp" class="form-text text-muted">We'll never share your password with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputUsername1">Your Name</label>
                            <input name="name" type="text" class="form-control" id="exampleInputUsername1" aria-describedby="emailHelp" required>
                            <small id="emailHelp" class="form-text text-muted">How we can call you</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputUsername1">Your Address</label>
                            <input name="address" type="text" class="form-control" id="exampleInputUsername1" aria-describedby="emailHelp" required>
                            <small id="emailHelp" class="form-text text-muted">Your Address</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email</label>
                            <input name="email" type="email" class="form-control" id="exampleInputEmail1" required>
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPhone1">Phone</label>
                            <input name="phone" type="number" class="form-control" id="exampleInputPhone1" required>
                            <small id="emailHelp" class="form-text text-muted">We'll never share your phone with anyone else.</small>
                        </div>
                        <button type="submit" class="btn btn-primary">Register</button>
                        <h3>${err}</h3>
                    </form>
                </div>
                <div class="col-lg-3"></div>
            </div>

        </div>
        <!-- /.container -->



        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>

</html>

