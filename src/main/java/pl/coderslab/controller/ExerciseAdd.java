package pl.coderslab.controller;

import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "ExerciseAdd", urlPatterns = {"/addexercise"})
public class ExerciseAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");

        if(action.equals("add")){
            getServletContext().getRequestDispatcher("/META-INF/views/addExercise.jsp").forward(request,response);
        }






//        getServletContext().getRequestDispatcher("/META-INF/views/exercises.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}





