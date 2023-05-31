package com.example.testjavafx;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HelloResultado {

    @FXML
    private Text descripcion;

    @FXML
    private Text nombre;

    @FXML
    private ImageView img2;
    Usuario usuario;

    void volcar(Usuario usuarioController){
        nombre.setText(usuarioController.getResultado().getNombre());
        descripcion.setText(usuarioController.getResultado().getDescripcion());
        try {
            img2.setImage(new Image(new FileInputStream(usuarioController.getResultado().getImagen())));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
