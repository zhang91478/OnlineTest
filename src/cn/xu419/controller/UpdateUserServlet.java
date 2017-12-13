package cn.xu419.controller;

import cn.xu419.dao.DaoFactory;
import cn.xu419.domain.User;
import cn.xu419.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateUserServlet extends HttpServlet{
    public UpdateUserServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setAccount(request.getParameter("account"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setEmail(request.getParameter("email"));
        user.setName(request.getParameter("name"));
        user.setSex(request.getParameter("sex"));

//        PrintWriter out = response.getWriter();
//
//        if(DaoFactory.createUserDao().updateUser(user))
//        {
//            out.println("用户更新成功");
//        }
//        request.getRequestDispatcher("/OnlineTest/manage").forward(request, response);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        if(DaoFactory.createUserDao().updateUser(user)){
            out.println("<script type=\"text/javascript\">alert(\"更新成功！\");window.location.href='/OnlineTest/manage';</script>");
        }
        else {
            out.println("<script type=\"text/javascript\">alert(\"更新   成功！\");window.location.href='/OnlineTest/manage';</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
