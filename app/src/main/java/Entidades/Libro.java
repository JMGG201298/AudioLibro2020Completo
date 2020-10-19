package Entidades;

import java.io.Serializable;

public class Libro implements Serializable {
    private String titulo;
    private String autor;
    private String fecha;
    private String resena;
    private int paginas;
    private int portada;
    private int audio;

    public Libro(String titulo, String autor, String fecha, String resena, int paginas, int portada, int audio) {
        this.titulo = titulo;
        this.autor = autor;
        this.fecha = fecha;
        this.resena = resena;
        this.paginas = paginas;
        this.portada = portada;
        this.audio = audio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getResena() {
        return resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getPortada() {
        return portada;
    }

    public void setPortada(int portada) {
        this.portada = portada;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }
}
