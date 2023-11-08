<%-- 
    Document   : login
    Created on : Nov 4, 2023, 10:58:02 PM
    Author     : vanli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/login.css">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
        <title>FAP | Login</title>
    </head>
    <body>
        <form method="POST" action="login">
            <div class="box">
                <div class="container">
                    <div class="top-header">
                        <img src="./assets/images/logo.png" class="logo"/>
                        <header>Login</header>
                    </div>
                    <div class="input-field">
                        <input type="text" class="input" placeholder="Username" name="username" required>
                        <i class="bx bx-user"></i>
                    </div>
                    <div class="input-field">
                        <input type="password" class="input" placeholder="Password" name="password" required>
                        <i class="bx bx-lock-alt"></i>
                    </div>
                    <div class="input-field">
                        <input type="submit" class="submit" value="Login">
                    </div>  
                    <div class="error-mess">
                        ${requestScope.error}
                    </div>
                </div>
            </div>            
        </form>
    </body>
</html>
