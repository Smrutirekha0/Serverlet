package com.txt;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class one extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {

            String name = request.getParameter("uname");

            Cookie ck = new Cookie("uname", name);
            ck.setMaxAge(60*60);

            response.addCookie(ck);

            response.sendRedirect("two");

        } catch(Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}