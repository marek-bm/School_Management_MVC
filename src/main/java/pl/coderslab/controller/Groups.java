package pl.coderslab.controller;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.UsersGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Groups", urlPatterns = {"/groups"})
public class Groups extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UsersGroup> groups=UsersGroup.loadAllGroups();
        request.setAttribute("groups",  groups);
        getServletContext().getRequestDispatcher("/META-INF/views/groups.jsp").forward(request,response);

    }
}
