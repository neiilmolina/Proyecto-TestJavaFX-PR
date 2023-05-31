package com.example.testjavafx;

import java.util.ArrayList;

public class Usuario {

    private int puntuacion;
    private ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
    private Resultado resultado;


    public Usuario(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Usuario() {
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public ArrayList<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "puntuacion=" + puntuacion +
                ", listaPreguntas=" + listaPreguntas +
                '}';
    }

    public void añadirPreguntas(Pregunta pregunta){
        listaPreguntas.add(pregunta);
    }

    public String nombreResultado(int puntuacion){
        String resultado;

        if(puntuacion >= 0 && puntuacion < 5){
            resultado = "Actimel";
        }else if(puntuacion < 8){
            resultado = "Vermú";
        }else if(puntuacion < 12){
            resultado = "Vino";
        }else if(puntuacion < 15){
            resultado = "Cerveza";
        }else if(puntuacion < 18){
            resultado = "Chupito";
        }else if(puntuacion < 21){
            resultado = "Jagger";
        }else if(puntuacion < 24){
            resultado = "Ron";
        }else {
            resultado = "Vodka";
        }
        return resultado;
    }

    public void sumarPuntos(int puntos){
        puntuacion = puntuacion + puntos;
    }

    public void asignarResultado(Resultado item){
        setResultado(item);
    }
    public Usuario generarPreguntas() {
        int numero;
        ArrayList<Integer> numeros = new ArrayList<>();
        String sql;
        Pregunta pregunta = new Pregunta();
        Respuesta respuestaAux = new Respuesta();

        // cojo 10 preguntas al azar
        for (int i = 0; i < 10; i++) {
            do {
                numero = HelloApplication.generateRandomNumber(1, 20);
            } while (numeros.indexOf(numero) != -1);

            numeros.add(numero);

            // recojo la respuesta con el id = numero en la BD y lo meto en el arraylist de respuestas del objeto Pregunta
            sql = "SELECT * FROM respuestas WHERE id =" + numero;
            respuestaAux = BD.devolverRespuesta(sql);

            // recojo la pregunta con el id = numero en la BD y lo meto en el arraylist de preguntas del objeto Usuario
            sql = "SELECT * FROM preguntas WHERE id =" + numero;
            pregunta = BD.devolverPregunta(sql);

            // Meto la respuesta recogida en la BD y lo meto en el arraylist de preguntas del objeto Usuario
            this.getListaPreguntas().add(pregunta);
            this.getListaPreguntas().get(i).añadirRespuestas(respuestaAux);

        }

        return this;
    }

    public void generarResultado(String resultado){
        String sql = "SELECT * FROM resultados WHERE nombre = '" + resultado + "';" ;
        this.setResultado(BD.devolverResultado(sql));
    }
}

