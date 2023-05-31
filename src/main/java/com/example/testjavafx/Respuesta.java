package com.example.testjavafx;


public class Respuesta {
    private String opcionA;
    private String opcionB;
    private String opcionC;
    private String opcionD;

    private int opcion;

    public Respuesta() {
    }

    public Respuesta(String opcionA, String opcionB, String opcionC, String opcionD, int opcion) {
        this.opcionA = opcionA;
        this.opcionB = opcionB;
        this.opcionC = opcionC;
        this.opcionD = opcionD;
        this.opcion = opcion;
    }

    public String getOpcionA() {
        return opcionA;
    }

    public void setOpcionA(String opcionA) {
        this.opcionA = opcionA;
    }

    public String getOpcionB() {
        return opcionB;
    }

    public void setOpcionB(String opcionB) {
        this.opcionB = opcionB;
    }

    public String getOpcionC() {
        return opcionC;
    }

    public void setOpcionC(String opcionC) {
        this.opcionC = opcionC;
    }

    public String getOpcionD() {
        return opcionD;
    }

    public void setOpcionD(String opcionD) {
        this.opcionD = opcionD;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }


    @java.lang.Override
    public java.lang.String toString() {
        return "Respuestas: \n" +
                " opcionA=" + opcionA + '\n' +
                " opcionB=" + opcionB + '\n' +
                " opcionC=" + opcionC + '\n' +
                " opcionD=" + opcionD + '\n' /* +
                " preguntaID=" + preguntaID*/ ;
    }




}

