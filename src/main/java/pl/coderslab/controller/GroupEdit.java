package pl.coderslab.controller;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.UsersGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GroupEdit", urlPatterns = {"/groupedit"})
public class GroupEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("title");
        UsersGroup gr=new UsersGroup(id,name);
        gr.saveToDB();
        response.sendRedirect("/groups");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("action"));
        UsersGroup group=UsersGroup.loadById(id);
        request.setAttribute("group", group);
        getServletContext().getRequestDispatcher("/META-INF/views/groupEdit.jsp").forward(request,response);

    }
}
