/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import dal.AccountDBContext;
import entities.Account;
import entities.Feature;
import entities.Role;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author vanli
 */
public class AuthorizationFilter implements Filter {
    
    private boolean hasAccess(ServletRequest request) {
        HttpServletRequest res = (HttpServletRequest) request;
        HttpSession session = res.getSession();
        Account loggedUser = (Account) session.getAttribute("account");
//        String username = loggedUser.getUsername();
        String url = res.getServletPath();
//        AccountDBContext db = new AccountDBContext();
//        loggedUser.setRoles(db.getRolesAndFeatures(username, url));
            
        ArrayList<Role> roles = loggedUser.getRoles();
        
        for (Role role : roles) {
            ArrayList<Feature> features = role.getFeatures();
            for (Feature feature : features) {
                if(feature.getUrl().equals(url)){
                    return true;
                }
            }
        }
            
        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        // Kiểm tra quyền truy cập của người dùng dựa trên vai trò và tính năng
        if (hasAccess(sr)) {
            // Nếu có quyền truy cập, cho phép tiếp tục xử lý request.
            fc.doFilter(sr, sr1);
        } else {
            sr1.getWriter().println("Access denied");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    

}
