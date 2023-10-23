/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author vanli
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Subject extends BaseEntity {

    private String code;
    private String name;
    private ArrayList<Group> groups = new ArrayList<>();

}
