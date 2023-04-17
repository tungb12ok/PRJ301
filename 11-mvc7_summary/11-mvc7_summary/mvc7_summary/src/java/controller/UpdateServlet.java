package controller;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import java.util.*;

public class UpdateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        int xNo = Integer.parseInt(request.getParameter("No"));
        JobDAO u = new JobDAO();
        Job x = u.getJob(xNo);
        if (x == null) {
            pr.println("<h2> A job is not found</h2>");
            request.getRequestDispatcher("update.html").include(request, response);
        } else {
            request.setAttribute("x", x);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        String xNo, xJobTitle, xCompany, xYear_Of_Experience, xDescription;
        xNo = request.getParameter("No");
        xJobTitle = request.getParameter("JobTitle");
        xCompany = request.getParameter("Company");
        xYear_Of_Experience = request.getParameter("YearOfExperiece");
        xDescription = request.getParameter("Description");
        boolean isOk = true;
        if (xNo == null || xNo.equals("")) {
            xYear_Of_Experience = "0";
        }
        if (xJobTitle == null || xJobTitle.trim().length() == 0 || xJobTitle.trim().equals("Invalid name!")) {
            xJobTitle = "Invalid name!";
            isOk = false;
        }
        if (xCompany == null || xCompany.trim().length() == 0 || xCompany.trim().equals("Invalid name!")) {
            xCompany = "Invalid name!";
            isOk = false;
        }
        if (xDescription == null || xDescription.trim().length() == 0 || xDescription.trim().equals("Invalid name!")) {
            xDescription = "Invalid name!";
            isOk = false;
        }
        
        if (xYear_Of_Experience == null || xYear_Of_Experience.trim().length() == 0) {
            xYear_Of_Experience = "0";
        }
        Job x = new Job(Integer.parseInt(xNo), Integer.parseInt(xYear_Of_Experience), xJobTitle, xCompany, xDescription);
        if (!isOk) {
            request.setAttribute("x", x);
            request.getRequestDispatcher("update.jsp").forward(request, response);
            return;
        }
        JobDAO u = new JobDAO();
        u.update(Integer.parseInt(xNo), x);
        List<Job> lst = u.getJob();
        request.setAttribute("lst", lst);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
