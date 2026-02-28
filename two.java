package com.txt;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class two extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        try {

            // Get name from URL
            String name = request.getParameter("name");

            // Get city (null first time)
            String city = request.getParameter("city");

            pw.println("<html><body style='text-align:center;margin-top:100px;'>");

            if (city == null) {

                // Step 1 → Ask for city
                pw.println("<h2>Enter City</h2>");
                pw.println("<form action='two' method='get'>");
                pw.println("City: <input type='text' name='city' required>");

                // Pass name again
                pw.println("<input type='hidden' name='name' value='" + name + "'>");

                pw.println("<br><br>");
                pw.println("<input type='submit' value='Next'>");
                pw.println("</form>");
            }
            else {

                // Step 2 → Show Save link
                pw.println("<h3>Click Save to Submit Data</h3>");

                pw.println("<a href='/Project2/three?name="
                        + name + "&city=" + city + "'>Save</a>");
            }

            pw.println("</body></html>");

        } catch (Exception e) {
            pw.println("Error: " + e.getMessage());
        }
    }
}