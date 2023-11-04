/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenlesson/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Claslesson/Class.java to edit this template
 */
package dal;

import entities.Group;
import entities.Lesson;
import entities.Room;
import entities.Subject;
import entities.TimeSlot;
import java.sql.Date;
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
public class LessonDBContext extends DBContext<Lesson> {

    public ArrayList<Lesson> getLessons(int iid, Date from, Date to) {
        ArrayList<Lesson> lessons = new ArrayList<>();
        try {
            String sql = "SELECT l.lid, l.[date], r.rid, t.tid, g.gid, g.gname, s.sucode, s.suname, i.iid, i.iname, l.isAttendance\n"
                    + "from Lesson l\n"
                    + "inner join Instructor i on l.instructorId = i.iid\n"
                    + "inner join TimeSlot t on t.tid = l.slotId\n"
                    + "inner join Room r on r.rid = l.roomId\n"
                    + "inner join [Group] g on l.groupId = g.gid\n"
                    + "inner join [Subject] s on s.sucode = g.subjectCode"
                    + "		WHERE i.iid = ? AND l.[date] >= ? AND l.[date] <= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, iid);
            stm.setDate(2, from);
            stm.setDate(3, to);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lesson lesson = new Lesson();
                lesson.setId(rs.getInt("lid"));
                lesson.setDate(rs.getDate("date"));
                lesson.setAttendance(rs.getBoolean("isAttendance"));
                Room room = new Room();
                room.setId(rs.getInt("rid"));
                lesson.setRoom(room);
                TimeSlot t = new TimeSlot();
                t.setId(rs.getInt("tid"));
                lesson.setSlot(t);
                Group g = new Group();
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                lesson.setGroup(g);
                Subject subject = new Subject();
                subject.setCode(rs.getString("sucode"));
                subject.setName(rs.getString("suname"));
                lesson.setSubject(subject);
                lessons.add(lesson);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lessons;
    }

    
    @Override
    public ArrayList<Lesson> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Claslesson/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Lesson entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Claslesson/Code/GeneratedMethodBody
    }

    @Override
    public void update(Lesson entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Claslesson/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lesson entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Claslesson/Code/GeneratedMethodBody
    }

    @Override
    public Lesson get(Lesson entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
