/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenlesson/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.instructor;

import dal.AttendanceDBContext;
import dal.LessonDBContext;
import entities.AttendanceRecord;
import entities.Lesson;
import entities.Student;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author vanli
 */
public class AttendanceController extends HttpServlet {
   
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        LessonDBContext lessonDB = new LessonDBContext();
        Lesson l = new Lesson();
        int id = Integer.parseInt(request.getParameter("id"));
        l.setId(id);
        Lesson lesson = lessonDB.get(l);
        request.setAttribute("lesson", lesson);
        
        AttendanceDBContext attDB = new AttendanceDBContext();
        ArrayList<AttendanceRecord> attendances = attDB.getAttendances(id);
        
        
        request.setAttribute("atts", attendances);
        
        request.getRequestDispatcher("../view/attendance.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String[] stuids = request.getParameterValues("stuid");
        Lesson lesson = new Lesson();
        lesson.setId(Integer.parseInt(request.getParameter("lessonid")));
        ArrayList<AttendanceRecord> atts = new ArrayList<>();
        for (String stuid : stuids) {
            int id = Integer.parseInt(stuid);
            AttendanceRecord a = new AttendanceRecord();
            Student s = new Student();
            s.setId(id);
            a.setStudent(s);
            a.setLesson(lesson);
            a.setDescription(request.getParameter("description"+stuid));
            a.setStatus(request.getParameter("status"+stuid).equals("present"));
            atts.add(a);
        }
        lesson.setAtts(atts);
        LessonDBContext lessonDB = new LessonDBContext();
        lessonDB.addAttendances(lesson);
        response.sendRedirect("./timetable");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
