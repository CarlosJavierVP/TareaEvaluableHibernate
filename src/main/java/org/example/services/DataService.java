package org.example.services;

import org.example.models.Opinion;
import org.example.models.Pelicula;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    private SessionFactory sessionFactory;


    public DataService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * 1º Historia de Usuario
     * @param p
     */
    public void saveMovie(Pelicula p){
        sessionFactory.inTransaction(session -> session.persist(p));
    }

    /**
     * 2º Historia de Usuario
     * @param correo
     * @return
     */
    public List<Opinion> opinionesUser(String correo){
        List<Opinion> listaOpiniones;
        try (Session session = sessionFactory.openSession()) {
            Query<Opinion> query = session.createQuery("select o from Opinion o where o.usuario =: correo", Opinion.class);
            query.setParameter("correo", correo);
            listaOpiniones = query.list();
        }catch (Exception e){
            listaOpiniones = new ArrayList<>(0);
        }
        return listaOpiniones;
    }

    /**
     * 3º Historia de usuario
     * @param id
     * @param opinion
     */
    public void updateMovie(Long id, Opinion opinion){
        sessionFactory.inTransaction(session -> {
            var p = session.get(Pelicula.class, id);
            p.addOpinion(opinion);
            session.persist(opinion);
        });
    }

    /**
     * 4º Historia de Usuario
     * @return lista de Películas con puntuación menor o igual que 3
     */
    public List<Pelicula> listMoviesMoreRating(){
        List<Pelicula> listaPeliculas;
        try (Session session = sessionFactory.openSession()) {
            Query<Pelicula> query = session.createQuery("select p from Opinion o join o.pelicula p where o.puntuacion <= 3  ", Pelicula.class);
            listaPeliculas = query.list();
        }catch (Exception e){
            listaPeliculas = new ArrayList<>(0);
        }
        return listaPeliculas;

    }





}
