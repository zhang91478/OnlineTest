package cn.xu419.controller;

import cn.xu419.domain.User;
import cn.xu419.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserLoginServlet extends HttpServlet{
    public UserLoginServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("account");
        String userPwd = request.getParameter("password");
        System.out.println(userName+userPwd);
        UserService userService = new UserService();

        User user = userService.loginUser(userName, userPwd);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        if (user.getAccount()!=null) {
            System.out.println("登陆成功");
            response.setContentType("text/html;charset=utf-8");
            out.println("<script type=\"text/javascript\">alert(\"登陆成功！\");window.location.href='/OnlineTest/question';</script>");
           // response.sendRedirect("/OnlineTest/question");

        }
        else {
            System.out.println("登陆失败");
            out.println("<script type=\"text/javascript\">alert(\"登陆失败！\");window.location.href='/index.html';</script>");
            //response.sendRedirect("/index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
