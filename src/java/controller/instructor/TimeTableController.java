/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.instructor;


import dal.InstructorDBContext;
import dal.LessonDBContext;
import dal.TimeSlotDBContext;
import entities.Account;
import entities.Instructor;
import entities.Lesson;
import entities.TimeSlot;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DateTimeHelper;


public class TimeTableController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account loggedUser = (Account) session.getAttribute("account");
        InstructorDBContext db = new InstructorDBContext();
        Instructor instructor = db.get(loggedUser.getUsername());
        String r_from = request.getParameter("from");
        String r_to = request.getParameter("to");
        ArrayList<Date> dates = new ArrayList<>();
        
        if(r_from == null)//this week
        {
            dates = DateTimeHelper.getCurrentWeekDates();
        }
        else
        {
            try {
                dates = DateTimeHelper.getSqlDatesInRange(r_from, r_to);
            } catch (ParseException ex) {
                Logger.getLogger(TimeTableController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
         TimeSlotDBContext timeDB = new TimeSlotDBContext();
         ArrayList<TimeSlot> slots = timeDB.list();
         
         LessonDBContext lessDB = new LessonDBContext();
        ArrayList<Lesson> lessons = lessDB.getLessons(instructor.getId(), dates.get(0), dates.get(dates.size()-1)); 
         request.setAttribute("instructor", instructor);
         request.setAttribute("slots", slots);
         request.setAttribute("dates", dates);
         request.setAttribute("from", dates.get(0));
         request.setAttribute("to", dates.get(dates.size()-1));
         request.setAttribute("lessons", lessons);         
         
         request.getRequestDispatcher("../view/timetable.jsp").forward(request, response);
        
        
    } 

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
        processRequest(request, response);
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
        processRequest(request, response);
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
