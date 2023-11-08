/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filter;

import dal.AccountDBContext;
import entities.Account;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author vanli
 */
public class AuthenticateFilter implements Filter {

    private boolean isAuthenticated(HttpServletRequest request) {
        Account account = (Account) request.getSession().getAttribute("account");
        return account != null;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;

        // Kiểm tra URL của request
        String requestURI = request.getRequestURI();
        String requestContextPath = request.getContextPath();
        System.out.println(requestURI);
        if (requestURI.equals("/Attendance_Taking_Sub_System/login")) {
            // Nếu URL là "/login", cho phép tiếp tục xử lý request mà không kiểm tra xác thực
            fc.doFilter(sr, sr1);
        } else {
            if (isAuthenticated(request)) {
                // Nếu có quyền truy cập, cho phép tiếp tục xử lý request.
                fc.doFilter(sr, sr1);
            } else {
                response.sendRedirect(requestContextPath + "/login");
//                    response.getWriter().println(requestURI);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }    
   
}


