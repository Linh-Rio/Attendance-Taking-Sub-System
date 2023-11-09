<%-- 
    Document   : attendedReport
    Created on : Oct 7, 2023, 1:45:13 PM
    Author     : vanli
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FAP | Attendance Taking</title>
        <link rel="stylesheet" href="../css/attendance.css"/>
    </head>
    <body>
        <div class="header">
            <img src="../assets/images/logo.png" class="logo-image"/>
            <a href="./timetable" class="timetable-btn">Time table</a>
        </div>
        <div class="page-infor">
            <h1 class="page-name">
                Attendance Taking                
            </h1>
            <div class="page-detail">
                <p>
                    Subject: ${requestScope.lesson.subject.name}
                </p>
                <p>

                    Group: ${requestScope.lesson.group.name}
                </p>
                <p>
                    Room: ${requestScope.lesson.room.name}
                </p>
                <p>
                    ${requestScope.lesson.slot.name}
                </p>                
            </div>
        </div>        

            <form action="attendance" method="POST">
                <table border="1px"> 
                    <tr>
                        <th>Student</th>
                        <th>Status</th>
                        <th>Description</th>
                        <th>Record Time</th>
                    </tr>
                    <c:forEach items="${requestScope.atts}" var="a">
                        <tr>
                            <td>${a.student.name}
                                <input type="hidden" name="stuid" value="${a.student.id}"/>
                            </td>
                            <td>
                                <input type="radio"
                                       <c:if test="${!a.status}">
                                           checked="checked"
                                       </c:if>
                                       name="status${a.student.id}" value="absent"/>absent
                                <input type="radio"
                                       <c:if test="${a.status}">
                                           checked="checked"
                                       </c:if>
                                       name="status${a.student.id}" value="present"/>present
                            </td>
                            <td>
                                <input type="text" value="${a.description}" name="description${a.student.id}" class="input-des"/>
                            </td>
                        <fmt:formatDate value="${a.recordTime}" pattern="HH:mm/dd/MM/YYY" var="formattedDate" />
                            <td>${formattedDate}</td>
                        </tr>   

                    </c:forEach>
                </table>
                <input type="hidden" value="${lesson.id}" name="lessonid"/>
                <input type="submit" value="Save" class="timetable-btn"/>
            </form>

    </body>
</html>

