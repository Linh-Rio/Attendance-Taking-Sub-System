<%-- 
    Document   : attendedReport
    Created on : Oct 7, 2023, 1:45:13 PM
    Author     : vanli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">

    </head>
    <body>
        <div class="container mt-4">
            <h1>Attendance System</h1>

            <form action="attend" method="POST">
                <table class="table table-bordered align-middle text-center">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Group</th>
                            <th>Code</th>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Status</th>

                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>IOT1702</td>
                            <td>HE130430</td>
                            <td>Ðô Manh Hùng</td>
                            <td><img src="#" width="128px" height="128px"/></td>
                            <td>
                                <input type="radio"/> absent
                                <input type="radio"/> present
                            </td>

                        </tr>
                    </tbody>
                </table>
                <button type="submit" class="btn btn-primary">Submit Attendance</button>
            </form>
        </div>
        <script src="js/bootstrap.bundle.min.js"></script>

    </body>
</html>
