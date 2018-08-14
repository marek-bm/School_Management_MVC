package pl.coderslab.controller;

import pl.coderslab.model.User;
import pl.coderslab.model.UsersGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.acl.Group;
import java.util.List;

@WebServlet(name = "GroupDetails", urlPatterns = {"/groupdetails"})
public class GroupDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupID=Integer.parseInt(request.getParameter("action"));
        List<User> groupMembers=User.loadAllByGroupId(groupID);
        request.setAttribute("group", groupMembers);

        getServletContext().getRequestDispatcher("/META-INF/views/groupDetails.jsp").forward(request,response);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
