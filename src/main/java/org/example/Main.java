package org.example;

import org.example.models.Opinion;
import org.example.models.Pelicula;
import org.example.services.DataService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //HibernateUtil.getSessionFactory();

        DataService ds = new DataService(HibernateUtil.getSessionFactory());

        /*
        Pelicula nuevaPeli = new Pelicula(null, "La vida de Brian",new ArrayList<>());

        ds.saveMovie(nuevaPeli);

        ds.opinionesUser("user1@example.com").forEach(System.out::println);

        Opinion op = new Opinion("Pelicula de humor parodiando al mesías","jaja@correo.com",10);

        ds.updateMovie(6L, op);


        ds.listMoviesMore3().forEach(System.out::println);

         */



    }
}