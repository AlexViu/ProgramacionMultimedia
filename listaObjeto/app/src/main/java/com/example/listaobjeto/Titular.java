package com.example.listaobjeto;

public class Titular {
    private String Titulo;
    private String Subtitulo;
    private int Imagen;

    public Titular(String titulo, String subtitulo, int imagen) {
        this.Titulo = titulo;
        this.Subtitulo = subtitulo;
        this.Imagen = imagen;
    }

    public int getImagen() {
        return Imagen;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getSubtitulo() {
        return Subtitulo;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public void setSubtitulo(String subtitulo) {
        Subtitulo = subtitulo;
    }
}
