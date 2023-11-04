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
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link href="assets/fontawesome/css/all.min.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">                
                <a class="navbar-brand fs-1" href="#">FPT University Academic Portal</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" 
                        aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="navbar-text">
                            <span>linhnvhe176341</span>
                        </li>
                        <li class="navbar-text">
                            <span>CAMPUS: FPTU-Hòa Lac</span>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">logout</a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Home</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">View Schedule</a>
            </li>
        </ul>     

        <div class="container">            
            <h2>Activities for linhnvhe176341 (Nguyễn Văn Linh)</h2>
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

        <div class="container">
            <form action="viewschedule" method="GET">
                From <input type="date" name="from" value="${requestScope.from}"/> <br/>
                To <input type="date" name="to" value="${requestScope.to}"/>
                <input type="hidden" value="${param.id}" name="id"/>
                <input type="submit" value="View"/>
            </form>
                <table class="table-bordered">
                <tr>
                    <td></td>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <td>
                            <fmt:formatDate value="${d}" pattern="dd-MM-yyyy" var="formattedDate" />
                            <p>${formattedDate}</p>
                        </td>
                    </c:forEach>
                </tr>
                <c:forEach items="${requestScope.slots}" var="s">
                    <tr>
                        <td>${s.startTime}-${s.endTime}</td>
                        <c:forEach items="${requestScope.dates}" var="d">
                            <td>
                                <c:forEach items="${requestScope.lessons}" var="lesson">
                                    <c:if test="${lesson.slot.id eq s.id and lesson.date eq d}">
                                        <a href="att?id=${lesson.id}"> ${lesson.group.name}-${lesson.subject.code}-${lesson.room.id}</a>

                                    </c:if>
                                </c:forEach>
                            </td>
                        </c:forEach>
                    </tr>  
                </c:forEach>
            </table>
        </div>

        <script src="js/bootstrap.bundle.min.js"></script>
    </body>
</html>
