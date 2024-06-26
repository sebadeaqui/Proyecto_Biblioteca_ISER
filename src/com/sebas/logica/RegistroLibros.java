package com.sebas.logica;

import com.sebas.entidades.Libro;
import java.util.ArrayList;
import java.util.List;

public class RegistroLibros {
    private List<Libro> libros;

    public RegistroLibros() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public boolean eliminarLibro(String titulo) {
        return libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }
}
