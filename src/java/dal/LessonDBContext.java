/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenlesson/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Claslesson/Class.java to edit this template
 */
package dal;

import entities.AttendanceRecord;
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

    public void addAttendances(Lesson lesson) {
        try {
            connection.setAutoCommit(false);
            String sql_update_isAtt = "UPDATE [Lesson] SET isAttendance = 1 WHERE lid =?";
            PreparedStatement stm_update_isAtt = connection.prepareStatement(sql_update_isAtt);
            stm_update_isAtt.setInt(1, lesson.getId());
            stm_update_isAtt.executeUpdate();

            String sql_remove_atts = "DELETE attendanceRecord WHERE lessonId =?";
            PreparedStatement stm_remove_atts = connection.prepareStatement(sql_remove_atts);
            stm_remove_atts.setInt(1, lesson.getId());
            stm_remove_atts.executeUpdate();

            for (AttendanceRecord att : lesson.getAtts()) {
                String sql_insert_att = "INSERT INTO [attendanceRecord]\n"
                        + "           ([lessonId]\n"
                        + "           ,[studentId]\n"
                        + "           ,[status]\n"
                        + "           ,[description]\n"
                        + "           ,[recordTime])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,?\n"
                        + "           ,GETDATE())";
                PreparedStatement stm_insert_att = connection.prepareStatement(sql_insert_att);
                stm_insert_att.setInt(1, lesson.getId());
                stm_insert_att.setInt(2, att.getStudent().getId());
                stm_insert_att.setBoolean(3, att.isStatus());
                stm_insert_att.setString(4, att.getDescription());
                stm_insert_att.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            try {
                connection.rollback();
                Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public ArrayList<Lesson> getLessons(int iid, Date from, Date to) {
        ArrayList<Lesson> lessons = new ArrayList<>();
        try {
            String sql = "SELECT l.lid, l.[date], r.rid, r.rname, t.tid, t.tname, t.startTime, t.endTime, g.gid, g.gname, s.sucode, s.suname, i.iid, i.iname, l.isAttendance\n"
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
                lesson.setIsAttendance(rs.getBoolean("isAttendance"));
                Room room = new Room();
                room.setId(rs.getInt("rid"));
                room.setName(rs.getString("rname"));
                lesson.setRoom(room);
                TimeSlot t = new TimeSlot();
                t.setId(rs.getInt("tid"));
                t.setName(rs.getString("tname"));
                t.setStartTime(rs.getTime("startTime"));
                t.setEndTime(rs.getTime("endTime"));
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
        try {
            String sql = "SELECT l.lid, l.[date], r.rid, r.rname, t.tid, t.tname, t.startTime, t.endTime, g.gid, g.gname, su.sucode, su.suname, i.iid, i.iname, l.isAttendance\n"
                    + "FROM Lesson l INNER JOIN [Instructor] i ON i.iid = l.instructorId\n"
                    + "                    			INNER JOIN [Group] g ON g.gid = l.groupId\n"
                    + "                   				INNER JOIN [TimeSlot] t ON l.slotId = t.tid\n"
                    + "                    			INNER JOIN [Room] r ON r.rid = l.roomId\n"
                    + "                    			INNER JOIN [Subject] su ON g.subjectCode = su.sucode\n"
                    + "WHERE l.lid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, entity.getId());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Lesson lesson = new Lesson();
                lesson.setId(rs.getInt("lid"));
                lesson.setDate(rs.getDate("date"));
                lesson.setIsAttendance(rs.getBoolean("isAttendance"));
                Room room = new Room();
                room.setId(rs.getInt("rid"));
                room.setName(rs.getString("rname"));
                lesson.setRoom(room);
                TimeSlot t = new TimeSlot();
                t.setId(rs.getInt("tid"));
                t.setName(rs.getString("tname"));
                t.setStartTime(rs.getTime("startTime"));
                t.setEndTime(rs.getTime("endTime"));
                lesson.setSlot(t);
                Group g = new Group();
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                lesson.setGroup(g);
                Subject subject = new Subject();
                subject.setCode(rs.getString("sucode"));
                subject.setName(rs.getString("suname"));
                lesson.setSubject(subject);
                return lesson;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LessonDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
