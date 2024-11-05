package com.example.apputnsqlite;

public class Libro {
    public int Id;
    public String Titulo;
    public int IdAutor;
    public String Isbn;
    public int AnioPublicacion;
    public int Revision;
    public int NroHojas;

    public Libro(int id, String titulo, int idAutor, String isbn, int anioPublicacion, int revision, int nroHojas) {
        Id = id;
        Titulo = titulo;
        IdAutor = idAutor;
        Isbn = isbn;
        AnioPublicacion = anioPublicacion;
        Revision = revision;
        NroHojas = nroHojas;
    }

}
