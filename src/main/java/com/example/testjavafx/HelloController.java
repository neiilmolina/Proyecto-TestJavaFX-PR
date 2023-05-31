package com.example.testjavafx;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ImageView img;

    @FXML
    private VBox main;

    @FXML
    private VBox container;

    @FXML
    private Button enviar;

    @FXML
    private Button next;

    @FXML
    private Label pregunta;

    @FXML
    private Button prev;

    @FXML
    private RadioButton r1;

    @FXML
    private RadioButton r2;

    @FXML
    private RadioButton r3;

    @FXML
    private RadioButton r4;

    ToggleGroup opciones2 = new ToggleGroup();

    //Respuestas tiene el valor seleccionado del ToggleGroup
    Toggle[] respuestas = new Toggle[10];

    // valores tiene la posicion (puntaje Supongo(?)) de cada pregunta
    Integer[] valores = new Integer[10];
    Usuario usuario = new Usuario();
    int posicion=0;

    ArrayList<Pregunta> preguntasLista = new ArrayList<>();

    ArrayList<RadioButton> opciones = new ArrayList<RadioButton>();

    // añado los botones a un arraylist para luego sacar su posicion
    public void listaBotones(){
        opciones.add(r1);
        opciones.add(r2);
        opciones.add(r3);
        opciones.add(r4);
    }


    // consigue la preegunta y opciones del indice
    public  void addPregunta(ArrayList<Pregunta> listado, int indice) {
        pregunta.setText(listado.get(indice).getPregunta());
        r1.setText(listado.get(indice).getRespuesta().getOpcionA());
        r2.setText(listado.get(indice).getRespuesta().getOpcionB());
        r3.setText(listado.get(indice).getRespuesta().getOpcionC());
        r4.setText(listado.get(indice).getRespuesta().getOpcionD());
        Image imgAux = null;

        try {
            imgAux = new Image(new FileInputStream(listado.get(indice).getImagen()));
            img.setImage(imgAux);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // desactivo todos los botones antes de continuar
        disableAll();
        listaBotones();
        addToggle(opciones2);
        // Comprobacion de si ya se habia seleccionado una respuesta para esa pregunta, en caso de que si, recoge el
        // valor del array de respuestas y lo asigna

        if ( respuestas[indice] != (null)){
            opciones2.selectToggle(respuestas[indice]);
        }
        alternarBoton(indice);
        // Desactivar los botones dependiendo del indice
    }

    public void alternarBoton(int indice){
        if(indice == 0){
            prev.setDisable(true);
        } else {
            prev.setDisable(false);
        }
        if(indice == 9 && !comprobarAllRespondido()){

            next.setDisable(true);
        } else {
            next.setDisable(false);
        }
    }

    public boolean comprobarAllRespondido(){
        boolean verificacion= false;
        if (!Arrays.stream(valores).toList().contains(null)){
            verificacion = true;
        }
        System.out.println("v: "+verificacion);
        return verificacion;
    }

    // Añade los botones al ToggleGroup
    public void addToggle(ToggleGroup grupo){
        r1.setToggleGroup(grupo);
        r2.setToggleGroup(grupo);
        r3.setToggleGroup(grupo);
        r4.setToggleGroup(grupo);

    }

    // Metodo que aumenta el indice
    public void siguiente(){
        posicion++;
        addPregunta(preguntasLista, posicion);
        // Mestro por consola el Array de valores para verificar que se aignan los valores
        System.out.println(Arrays.stream(valores).toList().toString());
    }

    public void anterior(){
        posicion--;
        addPregunta(preguntasLista, posicion);
        System.out.println(Arrays.stream(valores).toList().toString());
    }

    //comprueba si alguno de las opciones esta seleccionada
    public boolean comprobarSelected(){
        boolean seleccionado= false;
        for (RadioButton item : opciones){
            if (item.isSelected()){
                seleccionado = true;
            }
        }
        return seleccionado;
    }

    // Recoge el valor seleccionado
    public int valorSeleccionado(){
        int valor=0;
        for (RadioButton item : opciones){
            if (item.isSelected()){
                valor = opciones.indexOf(item);
            }
        }
        return valor;
    }

    // desactiva todos las opciones
    public void disableAll(){
        for (RadioButton item : opciones){
            item.setSelected(false);
        }
    }

    public int darResultado(){
        int suma=0;
        for (Integer valor : valores){
            suma+=valor;
        }
        System.out.println("result"+ suma);
        return suma;

    }

    // METODO NUEVO Metodo que al cambiar de vista, te muestra el resultado
    @FXML
    void accionar(ActionEvent event) throws IOException {
        // asignar la puntuacion
        int puntuacion = darResultado();
        // coger resultado dependiendo de la puntuacion
        String nombreResultado = usuario.nombreResultado(puntuacion);
        // generar resultados
        usuario.generarResultado(nombreResultado);
        System.out.println("resultado" + usuario.getResultado().toString());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Resultado.fxml"));
        Parent root = loader.load();
        HelloResultado resultado = loader.getController();
        // volcar usuario y poner el resultado y la descripcion
        resultado.volcar(usuario);
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        usuario = usuario.generarPreguntas();
        preguntasLista = usuario.getListaPreguntas();
        opciones2.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RadioButton selectedRadioButton = (RadioButton) newValue;
                valores[posicion]=valorSeleccionado();
                if (comprobarSelected()){
                    respuestas[posicion] = opciones2.getSelectedToggle();
                    opciones.get(valores[posicion]).setSelected(true);
                    valores[posicion] = valorSeleccionado();
                }
            }

            if (comprobarAllRespondido()){
                enviar.setVisible(true);
            }
        });
        System.out.println(usuario.getListaPreguntas().toString());
        addPregunta(preguntasLista, posicion);
    }
}
