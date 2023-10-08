<%-- 
    Document   : attendedTaking
    Created on : Oct 6, 2023, 4:41:40 PM
    Author     : vanli
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Attendance System</title>
    
    <!-- Include Bootstrap 5 CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h1>Attendance System</h1>
        
        <form action="attend" method="POST">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Group</th>
                        <th>Code</th>
                        <th>Name</th>
                        <th>Image</th>
                        <th>Status</th>
                        <th>Comment</th>
                        <th>Taker</th>
                        <th>Record time</th>
                    </tr>
                </thead>
                <tbody>
                        <tr>
                            <td>1</td>
                            <td>IOT1702</td>
                            <td>HE130430</td>
                            <td>Ð? M?nh Hùng</td>
                            <td><img src="#"/></td>
                            <td>Absent</td>
                            <td></td>
                            <td>sonnt5</td>
                            <td>1/19/2022 8:54:00</td>                            
                        </tr>
                </tbody>
            </table>
            <button type="submit" class="btn btn-primary">Submit Attendance</button>
        </form>
    </div>

    <!-- Include Bootstrap 5 JS (optional) -->
    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>

