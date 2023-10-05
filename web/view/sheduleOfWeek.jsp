<%-- 
    Document   : sheduleOfWeek
    Created on : Oct 5, 2023, 8:53:03 AM
    Author     : vanli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container">
                <a class="navbar-brand" href="#">FPT University Academic Portal</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">View Schedule</a>
                        </li>
                    </ul>
                </div>
                <div class="navbar-text">
                    <span>linhnvhe176341</span>
                    <span>logout</span>
                    <span>CAMPUS:FPTU-Hòa Lc</span>
                </div>
            </div>
        </nav>
        <h2>Activities for linhnvhe176341 (Nguyễn Văn Linh)</h2>
        <div>
            <p><mark>Note:</mark> These activities do not include extra-curriculum activities, such as club activities ...</p>
            <p><mark>Chú thích:</mark> Các hoạt động trong bảng dưới không bao gồm hoạt động ngoại khóa, ví dụ như hoạt động câu lạc bộ ...</p>
            <p>Các phòng bắt đầu bằng AL thuộc tòa nhà Alpha. VD: AL...
                Các phòng bắt đầu bằng BE thuộc tòa nhà Beta. VD: BE,..
                Các phòng bắt đầu bằng G thuộc tòa nhà Gamma. VD: G201,...
                Các phòng tập bằng đầu bằng R thuộc khu vực sân tập Vovinam.
                Các phòng bắt đầu bằng DE thuộc tòa nhà Delta. VD: DE,..
                Little UK (LUK) thuộc tầng 5 tòa nhà Delta
            </p>
        </div>
        <table>
            <thead>
                <tr>
                    <th rowspan="2">
                        <span><strong>YEAR</strong></span>
                        <select>
                            <option value="2020">2020</option>
                            <option value="2021">2021</option>
                            <option value="2022">2022</option>
                            <option value="2023">2023</option>
                            <option value="2024">2024</option>
                        </select><br/>
                        WEEK
                        <select>
                            <option value="1">02/01 To 08/01</option>
                            <option value="2">09/01 To 15/01</option>
                            <option value="3">16/01 To 22/01</option>
                            <option value="4">23/01 To 29/01</option>
                            <option value="5">30/01 To 05/02</option>
                            <option value="6">06/02 To 12/02</option>
                            <option value="7">13/02 To 19/02</option>
                        </select>
                    </th>
                    <th>Mon</th>
                    <th>Tue</th>
                    <th>Wed</th>
                    <th>Thu</th>
                    <th>Fri</th>
                    <th>Sat</th>
                    <th>Sun</th>
                </tr>
                <tr>
                    <th>02/10</th>
                    <th>03/10</th>
                    <th>04/10</th>
                    <th>05/10</th>
                    <th>06/10</th>
                    <th>07/10</th>
                    <th>08/10</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Slot 0</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
                <tr>
                    <td>Slot 1</td>
                    <td>
                        <p>
                            <a>PRJ301-</a>
                            <a>View Materials</a><br>
                            at BE-201
                            <a>
                                <br>
                                (
                                <font>attended</font>
                                )
                                <br>
                                <span>(7:30-9:50)</span>
                                <br>
                            </a>
                        </p>
                    </td>
                    <td>
                        <p>
                            <a>PRJ301-</a>
                            <a>View Materials</a><br>
                            at BE-201
                            <a>
                                <br>
                                (
                                <font>attended</font>
                                )
                                <br>
                                <span>(7:30-9:50)</span>
                                <br>
                            </a>
                        </p>
                    </td>
                    <td>
                        <p>
                            <a>PRJ301-</a>
                            <a>View Materials</a><br>
                            at BE-201
                            <a>
                                <br>
                                (
                                <font>attended</font>
                                )
                                <br>
                                <span>(7:30-9:50)</span>
                                <br>
                            </a>
                        </p>
                    </td>
                </tr>
                <tr>
                    <td>Slot 2</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>
            </tbody>

        </table>

        <script src="js/bootstrap.bundle.min.js"></script>
    </body>
</html>
