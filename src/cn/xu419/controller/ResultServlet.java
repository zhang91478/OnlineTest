package cn.xu419.controller;

import cn.xu419.domain.Answer;
import cn.xu419.services.RadioService;
import cn.xu419.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultServlet extends HttpServlet {
    public ResultServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int amount = Integer.parseInt(request.getParameter("amount"));
        //PrintWriter out = response.getWriter();
        RadioService radioService = new RadioService();
        ArrayList <Answer> list = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            String option = request.getParameter("question" + i);
            String num = request.getParameter("num" + i);
            list.add(radioService.getAnswer(num,option));
        }
        request.setAttribute("list", list);
        request.getRequestDispatcher("/OnlineTest/result").forward(request, response);
    }
}
