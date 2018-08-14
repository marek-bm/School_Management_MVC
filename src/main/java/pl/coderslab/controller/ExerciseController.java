package pl.coderslab.controller;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name="ExerciseController", urlPatterns = {"/exercises"})
public class ExerciseController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String title=request.getParameter("title");
        String descr=request.getParameter("description");


        Exercise ex=new Exercise(title,descr);
        ex.saveToDB();
        List<Exercise> exercises=Exercise.loadAll();
        request.setAttribute("exercises", exercises);
        getServletContext().getRequestDispatcher("/META-INF/views/exercises.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Exercise> exercises=Exercise.loadAll();
        request.setAttribute("exercises", exercises);

        getServletContext().getRequestDispatcher("/META-INF/views/exercises.jsp").forward(request,response);
    }
}


