package cn.xu419.controller;

import cn.xu419.domain.User;
import cn.xu419.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet{
    public UserAddServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setAccount(request.getParameter("account"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setSex(request.getParameter("sex"));
        UserService userService = new UserService();
        PrintWriter out = response.getWriter();
        //userService.addUser(user,request.getParameter("password"));
        if(userService.addUser(user,request.getParameter("password")))
        {
            out.println("<script type=\"text/javascript\">\n" +
                    "                alert(\"添加成功\");\n" +
                    "                window.location.href='/OnlineTest/manage';\n" +
                    "            </script>");
        }
        else {
            out.println("<script type=\"text/javascript\">\n" +
                    "                alert(\"添加  成功\");\n" +
                    "                window.location.href='/OnlineTest/manage';\n" +
                    "            </script>");
        }
//        request.getRequestDispatcher("/OnlineTest/manage").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
