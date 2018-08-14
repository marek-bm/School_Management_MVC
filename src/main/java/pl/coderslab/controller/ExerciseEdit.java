package pl.coderslab.controller;

import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExerciseEdit", urlPatterns = {"/editexercise"})
public class ExerciseEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        String title=request.getParameter("title");
        String description=request.getParameter("description");

        Exercise ex=new Exercise(id,title, description);
        ex.saveToDB();

        response.sendRedirect("/exercises");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("action"));
        Exercise exercise=Exercise.loadbyId(id);
        request.setAttribute("exercise", exercise);
        getServletContext().getRequestDispatcher("/META-INF/views/ExerciseEdit.jsp").forward(request,response);

    }
}
