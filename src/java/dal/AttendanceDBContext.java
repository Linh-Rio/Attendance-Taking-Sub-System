
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entities.AttendanceRecord;
import entities.Lesson;
import entities.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vanli
 */
public class AttendanceDBContext extends DBContext<AttendanceRecord> {

    public ArrayList<AttendanceRecord> getAttendances(int lessonid) {
        ArrayList<AttendanceRecord> atts = new ArrayList<>();
        try {
            String sql = "SELECT s.[sid],s.sname,ISNULL(a.status,0) as [status], ISNULL(a.description,'') as [description], \n"
                    + "ISNULL(a.recordTime, GETDATE()) as [recordTime]\n"
                    + "FROM Lesson l INNER JOIN [Group] g ON l.groupId = g.gid\n"
                    + "               INNER JOIN [Join] j ON g.gid = j.groupId\n"
                    + "               INNER JOIN [Student] s ON s.[sid] = j.studentId\n"
                    + "               LEFT JOIN attendanceRecord a ON s.[sid] = a.studentId \n"
                    + "               AND l.lid = a.lessonId\n"
                    + "WHERE l.lid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, lessonid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                AttendanceRecord att = new AttendanceRecord();
                Student student = new Student();
                Lesson lesson = new Lesson();
                student.setId(rs.getInt("sid"));
                student.setName(rs.getString("sname"));
                lesson.setId(lessonid);
                att.setStudent(student);
                att.setLesson(lesson);
                att.setStatus(rs.getBoolean("status"));
                att.setDescription(rs.getString("description"));
                att.setRecordTime(rs.getTimestamp("recordTime"));
                atts.add(att);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AttendanceDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atts;
    }

    @Override
    public ArrayList<AttendanceRecord> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(AttendanceRecord entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(AttendanceRecord entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(AttendanceRecord entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AttendanceRecord get(AttendanceRecord entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
