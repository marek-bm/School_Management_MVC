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
import java.io.Writer;

@WebServlet(name = "SolutionDisplayController", urlPatterns = {"/solutiondisplay"})
public class SolutionDisplayController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int solutionID= Integer.valueOf(request.getParameter("solution"));
        Solution sol=Solution.loadById(solutionID);

        int exercise_id=sol.getExercise_id();
        Exercise exercise=Exercise.loadbyId(exercise_id);

        int user_id=sol.getUser_id();
        User user=User.loadById(user_id);

        request.setAttribute("solution", sol);
        request.setAttribute("user", user);
        request.setAttribute("exercise", exercise);

        getServletContext().getRequestDispatcher("/META-INF/views/solutionDisplay.jsp").forward(request,response);

    }
}
