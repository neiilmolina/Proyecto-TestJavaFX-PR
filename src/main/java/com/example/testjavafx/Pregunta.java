package com.example.testjavafx;


public class Pregunta {
    private String pregunta;
    private Respuesta respuesta;
    private String imagen;
    private int idPregunta;

    public Pregunta() {
    }

    public Pregunta(String pregunta, String imagen, int idPregunta) {
        this.pregunta = pregunta;
        this.imagen = imagen;
        this.idPregunta = idPregunta;
    }

    public Pregunta(String pregunta, int idPregunta) {
        this.pregunta = pregunta;
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "pregunta='" + pregunta + "\n" +
                respuesta +
                imagen + "\n" +
                " idPregunta=" + idPregunta + "\n";
    }

    public void añadirRespuestas(Respuesta respuesta){
        setRespuesta(respuesta);
    }

}
