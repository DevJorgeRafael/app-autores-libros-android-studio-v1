package com.example.apputnsqlite;

public class Autor {
    public int Id;
    public String Nombres;
    public String Apellidos;
    public String IsoPais;
    public int Edad;

    public Autor(int Id, String Nombres, String Apellidos, String IsoPais, int Edad){
        this.Id = Id;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.IsoPais = IsoPais;
        this.Edad = Edad;
    }

}
