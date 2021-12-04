<%-- 
    Document   : searchBar
    Created on : May 12, 2021, 11:38:55 AM
    Author     : Hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<form action="search">
    <div class="form-group row">
        <label for="inputEmail3" class="col-sm-2 col-form-label">Name:</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputEmail3" placeholder="Name" name="name">
        </div>
    </div>
    <div class="form-row">
        <label for="inputEmail3" class="col-sm-2 col-form-label">Min:</label>
        <div class="col">
            <input type="number" class="form-control" placeholder="Min" name="min" min="0">
        </div>
        <label for="inputEmail3" class="col-sm-2 col-form-label">Max:</label>
        <div class="col">
            <input type="number" class="form-control" placeholder="Max" name="max" min="0">
        </div>
    </div>

    <p></p>
    <button class="btn btn-primary" type="submit">Search</button>
    <p></p>
</form>
