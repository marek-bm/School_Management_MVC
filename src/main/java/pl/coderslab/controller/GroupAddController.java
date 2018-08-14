package pl.coderslab.controller;

import pl.coderslab.model.UsersGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GroupAddController" , urlPatterns = {"/addgroup"})
public class GroupAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("groupName");
        UsersGroup group=new UsersGroup(name);
        group.saveToDB();
        response.sendRedirect("/groups");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action.equals("add")){
            getServletContext().getRequestDispatcher("/META-INF/views/addGroup.jsp").forward(request,response);
        }



    }
}
