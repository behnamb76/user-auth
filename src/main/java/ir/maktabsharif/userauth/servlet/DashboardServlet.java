package ir.maktabsharif.userauth.servlet;

import ir.maktabsharif.userauth.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)req).getSession();

        String firstname = (String) session.getAttribute("firstname");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Dashboard</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome " + firstname + "</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest)req).getSession();

        String firstname = (String) session.getAttribute("firstname");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Dashboard</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome " + firstname + "</h1>");
    }
}
