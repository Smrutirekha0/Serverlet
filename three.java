package com.txt;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class three extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            String city = request.getParameter("city");

            Cookie[] cookies = request.getCookies();
            String name = null;

            if(cookies != null){
                for(Cookie c : cookies){
                    if(c.getName().equals("uname")){
                        name = c.getValue();
                    }
                }
            }

            out.println("<h2>Final Output</h2>");
            out.println("Name: " + name + "<br>");
            out.println("City: " + city);

        } catch(Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}