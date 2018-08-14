package pl.coderslab.controller;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.User;
import pl.coderslab.model.UsersGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GroupDelete", urlPatterns = {"/groupdelete"})
public class GroupDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("action"));
        UsersGroup.delete(id);
        response.sendRedirect("/groups");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
