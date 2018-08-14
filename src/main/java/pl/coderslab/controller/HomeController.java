package pl.coderslab.controller;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = {""})
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Solution> solutions=Solution.loadAll();
        List<User> users=User.loadAll();
        List<Exercise> exercises=Exercise.loadAll();

        request.setAttribute("solutions",solutions);
        request.setAttribute("users",users);
        request.setAttribute("exercises", exercises);

        getServletContext().getRequestDispatcher("/META-INF/views/home.jsp").forward(request,response);
    }
}
