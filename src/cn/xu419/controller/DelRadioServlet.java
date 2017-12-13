package cn.xu419.controller;

import cn.xu419.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DelRadioServlet extends HttpServlet{
    public DelRadioServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean result = DaoFactory.createRadioDao().delRadioByNum(Integer.valueOf(request.getParameter("num")));
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        if(result){
            out.println("<script type=\"text/javascript\">alert(\"删除成功！\");window.location.href='/OnlineTest/manage';</script>");
        }
        else {
            out.println("<script type=\"text/javascript\">alert(\"删除     成功！\");window.location.href='/OnlineTest/manage';</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
