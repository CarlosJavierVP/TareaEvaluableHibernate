package org.example.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "opinion")
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private String usuario;

    private Integer puntuacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="pelicula_id")
    private Pelicula pelicula;



    public Opinion(String descripcion, String usuario, Integer puntuacion) {
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", usuario='" + usuario + '\'' +
                ", puntuacion=" + puntuacion +
                ", pelicula=" + pelicula.getTitulo() +
                '}';
    }
}