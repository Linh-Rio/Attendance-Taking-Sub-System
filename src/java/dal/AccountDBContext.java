/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entities.Account;
import entities.Feature;
import entities.Role;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vali
 */
public class AccountDBContext extends DBContext<Account> {

    @Override
    public ArrayList<Account> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Account entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Account entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Account entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account get(Account entity) {

        try {
            String sql = "SELECT Account.username\n"
                    + "FROM   Account \n"
                    + "	Where Account.username = ? and Account.[password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, entity.getUsername());
            stm.setString(2, entity.getPassword());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setUsername(rs.getString("username"));
                return account;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Role> getRolesAndFeatures(String username) throws ClassNotFoundException {
        ArrayList<Role> roles = new ArrayList<>();
        try {
            String sql = "SELECT r.roleid,r.rolename,f.fid,f.[url] FROM\n"
                    + "                    Account a\n"
                    + "                    INNER JOIN [Role_Account] ra ON a.username = ra.username\n"
                    + "                    INNER JOIN [Role] r ON ra.roleid = r.roleid\n"
                    + "                    INNER JOIN Role_Feature rf  ON rf.roleid= r.roleid\n"
                    + "                    INNER JOIN Feature f ON f.fid = rf.featureid\n"
                    + "                    WHERE a.username = ?";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                r.setId(rs.getInt("roleid"));
                r.setName(rs.getString("rolename"));

                Feature f = new Feature();
                f.setId(rs.getInt("fid"));
                f.setUrl(rs.getString("url"));

                r.getFeatures().add(f);
                roles.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return roles;
    }
}
