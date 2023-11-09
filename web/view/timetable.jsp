<%-- 
    Document   : sheduleOfWeek
    Created on : Oct 5, 2023, 8:53:03 AM
    Author     : vanli
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FAP | Timetable</title>
        <link href="../css/timetable.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>           

        <div>            
            <h2>Activities for ${sessionScope.account.username}</h2>
            <div>
                <p><mark>Note:</mark> These activities do not include extra-curriculum activities, such as club activities ...</p>
                <p><mark>Chú thích:</mark> Các hoạt động trong bảng dưới không bao gồm hoạt động ngoại khóa, ví dụ như hoạt động câu lạc bộ ...</p>
                <p>
                    Các phòng bắt đầu bằng AL thuộc tòa nhà Alpha. VD: AL...<br/>
                    Các phòng bắt đầu bằng BE thuộc tòa nhà Beta. VD: BE,..<br/>
                    Các phòng bắt đầu bằng G thuộc tòa nhà Gamma. VD: G201,...<br/>
                    Các phòng tập bằng đầu bằng R thuộc khu vực sân tập Vovinam.<br/>
                    Các phòng bắt đầu bằng DE thuộc tòa nhà Delta. VD: DE,..<br/>
                    Little UK (LUK) thuộc tầng 5 tòa nhà Delta
                </p>
            </div>
        </div>
        <div>
            <form action="timetable" method="GET">
                From <input type="date" name="from" value="${requestScope.from}"/> <br/>
                To <input type="date" name="to" value="${requestScope.to}"/>
                <input type="hidden" value="${param.id}" name="id"/>
                <input type="submit" value="View"/>
            </form>

            <div class="timetable-container">
                <c:forEach items="${requestScope.dates}" var="d">
                    <div class="timetable-element">                    
                        <div class="timetable-date">
                            <fmt:formatDate value="${d}" pattern="E, dd-MM" var="formattedDate" />
                            <p>${formattedDate}</p>
                        </div>
                        <div class="timetable-slot-container">
                            <c:forEach items="${requestScope.slots}" var="s">
                                <c:forEach items="${requestScope.dates}" var="d">
                                    <c:forEach items="${requestScope.lessons}" var="lesson">
                                        <c:if test="${lesson.slot.id eq s.id and lesson.date eq d}">

                                            <div class="timetable-slot">
                                                <div class="slot-index">
                                                    <div>
                                                        ${s.name}
                                                    </div>
                                                    <div>
                                                        <c:if test="${lesson.isAttendance}">attended</c:if>
                                                        <c:if test="${!lesson.isAttendance}">Not yet</c:if>
                                                        </div>
                                                    </div>
                                                    <div class="slot-detail">                                
                                                        <div>Subject code: ${lesson.subject.code}</div>
                                                        <div>Room: ${lesson.room.name}</div>
                                                        <div>Group: ${lesson.group.name}</div>
                                                    </div>
                                                </div>
                                        </c:if>
                                    </c:forEach>
                                </c:forEach>        
                            </c:forEach>                           

                        </div>
                    </div>
                </c:forEach>
            </div>

            <table class="table">
                <thead>
                    <tr>
                        <th></th>
                            <c:forEach items="${requestScope.dates}" var="d">
                            <th>
                                <fmt:formatDate value="${d}" pattern="dd-MM-yyyy" var="formattedDate" />
                                <p>${formattedDate}</p>
                            </th>
                        </c:forEach>                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.slots}" var="s">
                        <tr>
                            <td>${s.startTime}-${s.endTime}</td>
                            <c:forEach items="${requestScope.dates}" var="d">
                                <td>
                                    <c:forEach items="${requestScope.lessons}" var="lesson">
                                        <c:if test="${lesson.slot.id eq s.id and lesson.date eq d}">
                                            <a href="attendance?id=${lesson.id}"> ${lesson.group.name}-${lesson.subject.code}-${lesson.room.name}</a>
                                            <c:if test="${lesson.isAttendance}">(attended)</c:if>
                                            <c:if test="${!lesson.isAttendance}">(Not yet)</c:if>
                                        </c:if>
                                    </c:forEach>
                                </td>
                            </c:forEach>
                        </tr>  
                    </c:forEach>                    
                </tbody>
            </table>
        </div>

    </body>
</html>
