/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entities.Account;
import entities.Instructor;
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
public class InstructorDBContext extends DBContext<Instructor> {

    @Override
    public ArrayList<Instructor> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Instructor entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Instructor entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Instructor entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Instructor get(Instructor entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Instructor get(String userName) {

        try {
            String sql = "SELECT [iid]\n"
                    + "      ,[iname]\n"
                    + "      ,[igender]\n"
                    + "      ,[idob]\n"
                    + "      ,[iphoneNum]\n"
                    + "      ,[iemail]\n"
                    + "      ,[username]\n"
                    + "  FROM [dbo].[Instructor]\n"
                    + "  where username = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, userName);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Instructor instructor = new Instructor();
                instructor.setUsername(rs.getString("username"));
                instructor.setId(rs.getInt("iid"));
                instructor.setGender(rs.getString("igender"));
                instructor.setDob(rs.getDate("idob"));
                instructor.setEmail(rs.getString("iemail"));
                instructor.setName(rs.getString("iname"));
                instructor.setPhoneNum(rs.getString("iphoneNum"));
                return instructor;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
