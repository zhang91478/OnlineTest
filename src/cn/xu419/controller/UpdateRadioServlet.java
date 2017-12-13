package cn.xu419.controller;

import cn.xu419.dao.DaoFactory;
import cn.xu419.domain.Radio;
import cn.xu419.domain.User;
import cn.xu419.services.RadioService;
import cn.xu419.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class UpdateRadioServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Radio radio = new Radio();
        radio.setCourse(request.getParameter("course"));
        radio.setStem(request.getParameter("stem"));
        radio.setOptionOne(request.getParameter("one"));
        radio.setOptionTwo(request.getParameter("two"));
        radio.setOptionThree(request.getParameter("three"));
        radio.setOptionFour(request.getParameter("four"));
        radio.setScore(Integer.valueOf(request.getParameter("score")));
        radio.setNum(Integer.valueOf(request.getParameter("num")));

        boolean result = DaoFactory.createRadioDao().updateRadio(radio);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        if(result){
            out.println("<script type=\"text/javascript\">alert(\"更新成功！\");window.location.href='/OnlineTest/manage';</script>");
        }
        else {
            out.println("<script type=\"text/javascript\">alert(\"更新   成功！\");window.location.href='/OnlineTest/manage';</script>");
        }
        //response.sendRedirect("/OnlineTest/manage");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
