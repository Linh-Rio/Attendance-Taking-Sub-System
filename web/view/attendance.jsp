<%-- 
    Document   : attendedReport
    Created on : Oct 7, 2023, 1:45:13 PM
    Author     : vanli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${requestScope.lesson.group.name}-${requestScope.lesson.subject.name}-${requestScope.lesson.room.name}
            -${requestScope.lesson.slot.name}</h1>
        <br/>
        <form action="attendance" method="POST">
            <table border="1px"> 
                <tr>
                    <td>Student</td>
                    <td>Status</td>
                    <td>Description</td>
                    <td>Record Time</td>
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
                        <input type="text" value="${a.description}"
                               name="description${a.student.id}"/>
                    </td>
                    <td>${a.recordTime}</td>
                </tr>   
                    
                </c:forEach>
            </table>
            <input type="hidden" value="${lesson.id}" name="lessonid"/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>

