<%--
  Created by IntelliJ IDEA.
  User: darkshadow
  Date: 6/17/21
  Time: 5:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <%@include file="../reuse/css.jsp" %>
</head>
<body>
<div class="container">
    <%@include file="../reuse/navbar.jsp" %>
    <%--    <a href="${pageContext.servletContext.contextPath}/customer?action=listPage">View Customer List</a>--%>

    <div class="row">
        <div class="col-md-4">
            <h5>Customer Create Form</h5>
            <hr>
            <form action="${pageContext.servletContext.contextPath}/customer?action=save" method="post">
                <div class="form-group">
                    <label for="fullName">Full Name</label>
                    <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Full Name">
                    <span style="color: red;font-style: italic">${customerError.fullNameError}</span>

                </div>
                <br>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="Address">
                    <span style="color: red;font-style: italic">${customerError.addressError}</span>
                </div>
                <br>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" name="email"
                           aria-describedby="emailHelp"
                           placeholder="Enter email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                        else.</small>
                    <span style="color: red;font-style: italic">${customerError.emailError}</span>

                </div>
                <br>
                <div class="form-group">
                    <label for="mobileNumber">Mobile</label>
                    <input type="text" class="form-control" id="mobileNumber" name="mobileNumber"
                           placeholder="Mobile Number">
                    <span style="color: red;font-style: italic">${customerError.mobileNumberError}</span>

                </div>

                <br>

                <div class="form-group">
                    <label>Gender</label>
                    <input type="radio" name="gender" value="MALE" checked>MALE
                    <input type="radio" name="gender" value="FEMALE">FEMALE
                    <input type="radio" name="gender" value="OTHER">OTHERS
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

            <span style="color: blue">${message}</span>
        </div>
        <div class="col-md-8">
            <h5>Customer List</h5>
            <hr>
            <c:forEach var="color" items="${colorList}">
                <h3 style="color: ${color}">${color}</h3>
            </c:forEach>
        </div>
    </div>


</div>
</body>
</html>
