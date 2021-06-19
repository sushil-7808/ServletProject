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
    <style>
        #customers {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #customers td, #customers th {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #customers tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #customers tr:hover {
            background-color: #ddd;
        }

        #customers th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #04AA6D;
            color: white;
        }
    </style>
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

                <input type="text" value="${customer.id}" name="id" hidden>
                <div class="form-group">
                    <label for="fullName">Full Name</label>
                    <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Full Name"
                           value="${customer.fullName}">
                    <span style="color: red;font-style: italic">${customerError.fullNameError}</span>

                </div>
                <br>
                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="Address"
                           value="${customer.address}">
                    <span style="color: red;font-style: italic">${customerError.addressError}</span>
                </div>
                <br>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" name="email"
                           value="${customer.email}"
                           aria-describedby="emailHelp"
                           placeholder="Enter email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                        else.</small><br>
                    <span style="color: red;font-style: italic">${customerError.emailError}</span>

                </div>
                <br>
                <div class="form-group">
                    <label for="mobileNumber">Mobile</label>
                    <input type="text" class="form-control" id="mobileNumber" name="mobileNumber"
                           value="${customer.mobileNumber}"
                           placeholder="Mobile Number">
                    <span style="color: red;font-style: italic">${customerError.mobileNumberError}</span>

                </div>

                <br>

                <div class="form-group">
                    <label>Gender</label>
                    <input type="radio" name="gender" value="MALE"  ${customer.g == "MALE"? "checked":""}>MALE
                    <input type="radio" name="gender" value="FEMALE"  ${customer.g == "FEMALE"? "checked":""}>FEMALE
                    <input type="radio" name="gender" value="OTHER"  ${customer.g == "OTHER"? "checked":""}>OTHERS
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

            <span style="color: blue">${message}</span>
        </div>
        <div class="col-md-8">
            <h5>Customer List</h5>
            <hr>
            <%--            <c:forEach var="color" items="${colorList}">--%>
            <%--                <h3 style="color: ${color}">${color}</h3>--%>
            <%--            </c:forEach>--%>
            <table id="customers">
                <tr>
                    <th>Id</th>
                    <th>Fullname</th>
                    <th>Address</th>
                    <th>Email</th>
                    <th>Mobile Number</th>
                    <th>Gender</th>
                    <th>Action</th>
                </tr>
                <%int i = 1; %>
                <c:forEach var="c" items="${customerList}">
                    <tr>
                        <td><%=i++%>
                        </td>
                        <td>${c.fullName}</td>
                        <td>${c.address}</td>
                        <td>${c.email}</td>
                        <td>${c.mobileNumber}</td>
                        <td>${c.gender}</td>
                        <td>

                            <a href="/customer?action=edit&id=${c.id}">
                                <button class="btn btn-sm btn-primary">E</button>
                            </a>
                            <a href="/customer?action=delete&id=${c.id}">
                                <button class="btn btn-sm btn-danger">D</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>

            </table>


        </div>
    </div>


</div>
</body>
</html>
