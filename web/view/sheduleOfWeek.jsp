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
            <table class="table d-none d-lg-table table-bordered align-middle">
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
                                <a class="link-info">PRJ301-</a>
                                <a class="badge text-decoration-none" style="background-color: #EC971F;">View Materials</a><br>
                                at BE-201
                                <span>(<span style="color: green;">attended</span>)</span>
                                <span class="bg-info-subtle">(7:30-9:50)</span>
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
                        <td>
                            <p>
                                <span class="link-info">PRJ301-</span>
                                <a class="badge text-decoration-none" style="background-color: #EC971F;">View Materials</a><br>
                                <span>at BE-201</span><br/>
                                <span class="badge" style="background-color: #5E5E5E;">Meet URL</span><br/>
                                <span>(<span style="color: green;">attended</span>)</span><br/>
                                <span class="bg-info-subtle">(7:30-9:50)</span>
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

            <h3 class="d-lg-none text-center">Current week: 1/10/2023 - 07/10/2023</h3>
            <table class="d-lg-none table table-borderless align-middle">
                <thead class="text-center">
                    <tr>
                        <th colspan="7">
                            <span>  
                                <i class="fa-solid fa-caret-left"></i>
                            </span>
                            <span class="p-5">October 2023</span>
                            <span><i class="fa-solid fa-caret-right"></i></span>      
                        </th>
                    </tr>
                    <tr>
                        <th>Sun</th>
                        <th>Mon</th>
                        <th>Tue</th>
                        <th>Wed</th>
                        <th>Thu</th>
                        <th>Fri</th>
                        <th>Sat</th>
                    </tr>
                    <tr>
                        <th>1</th>
                        <th>2</th>
                        <th>3</th>
                        <th>4</th>
                        <th>5</th>
                        <th>6</th>
                        <th>7</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th colspan="2">
                            <div class=" text-center">

                                <div>
                                    1/10
                                </div>
                                <div>
                                    Sun
                                </div>                           

                            </div>
                        </th>
                        <td colspan="5">
                            <div class="d-flex flex-column">
                                <div class="d-flex flex-row justify-content-evenly">
                                    <div class="p-2">
                                        <div>slot 1</div>
                                        <div>7:30-9:50</div>
                                        <div>present</div>
                                        <div>Material</div>
                                    </div>
                                    <div class="p-2">
                                        <div>Room: BE-201</div>
                                        <div>Subject Code: PRJ301</div>
                                        <div>SessionNo: 9</div>
                                        <div>Group class: SE1753</div>
                                        <div>Lecturer: sonnt5</div>
                                    </div>
                                </div>
                                <div class="d-flex flex-row justify-content-evenly">
                                    <div class="p-2">
                                        <div>slot 1</div>
                                        <div>7:30-9:50</div>
                                        <div>present</div>
                                        <div>Material</div>
                                    </div>
                                    <div class="p-2">
                                        <div>Room: BE-201</div>
                                        <div>Subject Code: PRJ301</div>
                                        <div>SessionNo: 9</div>
                                        <div>Group class: SE1753</div>
                                        <div>Lecturer: sonnt5</div>
                                    </div>
                                </div>
                                <div class="d-flex flex-row justify-content-evenly">
                                    <div class="p-2">
                                        <div>slot 1</div>
                                        <div>7:30-9:50</div>
                                        <div>present</div>
                                        <div>Material</div>
                                    </div>
                                    <div class="p-2">
                                        <div>Room: BE-201</div>
                                        <div>Subject Code: PRJ301</div>
                                        <div>SessionNo: 9</div>
                                        <div>Group class: SE1753</div>
                                        <div>Lecturer: sonnt5</div>
                                    </div>
                                </div>

                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <script src="js/bootstrap.bundle.min.js"></script>
    </body>
</html>
