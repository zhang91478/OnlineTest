package cn.xu419.controller;

import cn.xu419.domain.Admin;
import cn.xu419.services.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("account");
        String adminPwd = request.getParameter("password");
        AdminService adminService = new AdminService();

        Admin admin = adminService.loginAdmin(adminName,adminPwd);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        if (admin.getAccount()!=null) {
            System.out.println("登陆成功");
            response.sendRedirect("/OnlineTest/manage");
         //   response.setContentType("text/html;charset=utf-8");
            out.println("<script type=\"text/javascript\">alert(\"登陆成功！\");window.location.href='/OnlineTest/manage';</script>");

        }
        else {
            System.out.println("登陆失败");
            //response.sendRedirect("/adminLogin.html");
            out.println("<script type=\"text/javascript\">alert(\"登陆   成功！\");window.location.href='/OnlineTest/manage';</script>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
