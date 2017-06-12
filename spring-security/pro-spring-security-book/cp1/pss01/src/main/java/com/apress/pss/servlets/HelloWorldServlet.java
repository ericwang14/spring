package com.apress.pss.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/hello"})
public class HelloWorldServlet extends HttpServlet {


    private static final long serialVersionUID = 2218168052197231866L;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res){
        try {
            System.out.println("test");
            res.getWriter().write("Hello World");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
