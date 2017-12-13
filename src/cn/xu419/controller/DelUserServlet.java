package cn.xu419.controller;

import cn.xu419.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DelUserServlet extends HttpServlet{
    public DelUserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        boolean result = DaoFactory.createUserDao().delUserByAccount(req.getParameter("account"));

        //response.sendRedirect("/OnlineTest/manage");
        if(result){
            out.println("<script type=\"text/javascript\">alert(\"删除成功！\");window.location.href='/OnlineTest/manage';</script>");
        }
        else {
            out.println("<script type=\"text/javascript\">alert(\"删除      成功！\");window.location.href='/OnlineTest/manage';</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
