package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

/***
 * Clase Película
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @OneToMany(mappedBy ="pelicula", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST )
    private List<Opinion> opiniones = new ArrayList<Opinion>();

    /***
     * Metodo para añadir una opinión de la película
     * @param o de Opinion
     */
    public void addOpinion(Opinion o) {
        o.setPelicula(this);
        opiniones.add(o);
    }


    /***
     * Metodo toString para devolver la información del objeto
     * @return data
     */
    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", opiniones=" + opiniones +
                '}';
    }
}