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
public class Student extends BaseEntity {

    private int id;
    private String sCode;
    private String name;
    private String gender;
    private Date dob;
    private String phoneNum;
    private String email;
    private String avatar;
    private String username;
    private ArrayList<Group> groups = new ArrayList<>();

}
