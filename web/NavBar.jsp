<%-- 
    Document   : NavBar
    Created on : May 11, 2021, 10:54:16 AM
    Author     : Hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <c:choose>
                    <c:when test="${sessionScope.account.roll_id == 2}">
                        <li class="nav-item active">
                            <a class="nav-link" href="admin-home">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>   
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item active">
                            <a class="nav-link" href="home">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>               
                        <li class="nav-item">
                            <a class="nav-link" href="cart">Cart</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="history">History</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${sessionScope.account != null}">
                        <li class="nav-item">
                            <a class="nav-link" style="color: gold">${sessionScope.account.displayName}</a>
                        </li>
<!--                        <li class="nav-item">
                            <a class="nav-link" href="history">History</a>
                        </li>-->
                        <li class="nav-item">
                            <a class="nav-link" href="logout">Logout</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="login">Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="register">Register</a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>
        </div>
    </div>
</nav>
