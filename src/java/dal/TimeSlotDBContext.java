/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entities.TimeSlot;
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
public class TimeSlotDBContext extends DBContext<TimeSlot> {

    @Override
    public ArrayList<TimeSlot> list() {
        ArrayList<TimeSlot> slots = new ArrayList<>();
        try {
            String sql = "SELECT [tid]\n"
                    + "      ,[tname]\n"
                    + "      ,[startTime]\n"
                    + "      ,[endTime]\n"
                    + "  FROM [TimeSlot]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                TimeSlot t = new TimeSlot();
                t.setId(rs.getInt("tid"));
                t.setName(rs.getString("tname"));
                t.setStartTime(rs.getTime("startTime"));
                t.setEndTime(rs.getTime("endTime"));
                slots.add(t);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TimeSlotDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slots;
    }

    @Override
    public void insert(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TimeSlot get(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
