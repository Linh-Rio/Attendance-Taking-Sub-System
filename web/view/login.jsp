<%-- 
    Document   : login
    Created on : Nov 4, 2023, 10:58:02 PM
    Author     : vanli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="../css/login.css"/>
    </head>
    <body>
        <form method="POST" action="login">
            <table>
                <tr>
                    <td>
                        <label for="username">User name:</label>
                    </td>
                    <td>            
                        <input type="text" id="username" name="username" /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="username">Password:</label>
                    </td>
                    <td>
                        <input type="password" name="password" />
                    </td>
                </tr>               
                <tr>
                    <td>
                        <input type="submit" value="Login"/>
                    </td>
                </tr>
            </table>
            <div style="color: red;">
                ${requestScope.error}
            </div>

        </form>
    </body>
</html>
