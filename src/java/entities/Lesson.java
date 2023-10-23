/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
import java.util.ArrayList;
/**
 *
 * @author vanli
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Lesson extends BaseEntity {

    private int id;
    private Date date;
    private int index;
    private boolean isAttendance;
    private Instructor instructor;
    private TimeSlot slot;
    private Room room;
    private Group group;
    private ArrayList<AttendanceRecord> atts = new ArrayList<>();

}
