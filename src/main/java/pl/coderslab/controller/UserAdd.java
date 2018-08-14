package pl.coderslab.controller;

import pl.coderslab.model.User;
import pl.coderslab.model.UsersGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserAdd",urlPatterns = {"/adduser"})
public class UserAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        Integer userGroup=Integer.parseInt(request.getParameter("group"));

        if(userGroup.equals("") || userGroup.equals(" ") || userGroup.equals(null))
            userGroup=0;

        User user=new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.saveToDB();

        response.sendRedirect("/users");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UsersGroup> groups=UsersGroup.loadAllGroups();
        request.setAttribute("groups",  groups);

        String action=request.getParameter("action");
        if(action.equals("add")){
            getServletContext().getRequestDispatcher("/META-INF/views/addUser.jsp").forward(request,response);
        }


    }
}
