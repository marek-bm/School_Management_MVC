package pl.coderslab.controller;

import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserEdit", urlPatterns = {"/edituser"})
public class UserEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        int groupId=Integer.parseInt(request.getParameter("user_group_id"));

//        public User(int id, String name, String username, String password, String email, int groupId) {

        User user=new User(id,username,password,email,groupId);
        user.saveToDB();

        response.sendRedirect("/users");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId=Integer.parseInt(request.getParameter("action"));
        if(userId>0){
            User user=User.loadById(userId);
            request.setAttribute("user", user);
        }

        getServletContext().getRequestDispatcher("/META-INF/views/userEdit.jsp").forward(request,response);




    }
}
