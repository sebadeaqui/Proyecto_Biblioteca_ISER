package com.sebas.entidades;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private int anoPublicacion;

    public Libro(String titulo, String autor, String genero, int anoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacion = anoPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    @Override
    public String toString() {
        return titulo + " - " + autor;
    }
}
