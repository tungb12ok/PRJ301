package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class Delete1Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        int xNo = Integer.parseInt(request.getParameter("No"));
        JobDAO u = new JobDAO();
        Job x =  u.getJob(xNo);
        if (x == null) {
            pr.println("<h2> A student is not found</h2>");
            request.getRequestDispatcher("delete1.html").include(request, response);
        } else {
            u.delete(xNo);
            List<Job> lst = u.getJob();
            request.setAttribute("lst", lst);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        int xNo = Integer.parseInt(request.getParameter("No"));
        JobDAO u = new JobDAO();
        Job x = u.getJob(xNo);
        if (x == null) {
            pr.println("<h2> A student is not found</h2>");
            request.getRequestDispatcher("delete1.html").include(request, response);
        } else {
            u.delete(xNo);
            List<Job> lst = u.getJob();
            request.setAttribute("lst", lst);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }

    }
}
