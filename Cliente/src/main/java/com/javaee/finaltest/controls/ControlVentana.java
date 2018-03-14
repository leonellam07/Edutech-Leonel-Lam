/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaee.finaltest.controls;

import com.javaee.finaltest.images.imagesRoutes;
import java.io.IOException;
import java.net.URL;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author JLAM
 */
public class ControlVentana extends Stage {

    private Image IconoVentana = imagesRoutes.getIcon();
    private FXMLLoader Loader;
    private Parent RaizForm;
    private URL RutaForm;

    public Image getIconoVenatana() {
        return IconoVentana;
    }

    public void setIconoVenatana(Image IconoVentana) {
        this.IconoVentana = IconoVentana;
        getIcons().add(IconoVentana);
    }

    public Parent getRaizForm() {
        return RaizForm;
    }

    public void setRaizForm(Parent RaizForm) {
        this.RaizForm = RaizForm;
    }

    public URL getRutaForm() {
        return RutaForm;
    }

    public void setRutaForm(URL RutaForm) {
        this.RutaForm = RutaForm;
    }

    public ControlVentana() {
        super();
        getIcons().add(IconoVentana);
    }

    public ControlVentana(URL RutaForm) {
        super();
        try {
            this.RutaForm = RutaForm;
            this.Loader = new FXMLLoader(this.RutaForm);
            this.RaizForm = Loader.load();
            getIcons().add(this.IconoVentana);
            setScene(new Scene(this.RaizForm));
        } catch (IOException ex) {

        }
    }

    public ControlVentana(URL RutaForm, String NombreForm) {
        super();
        try {
            this.RutaForm = RutaForm;
            this.Loader = new FXMLLoader(this.RutaForm);
            this.RaizForm = this.Loader.load();
            getIcons().add(this.IconoVentana);
            setScene(new Scene(this.RaizForm));
            setTitle(NombreForm);
        } catch (IOException ex) {

        }
    }

    public ControlVentana(URL RutaForm, String NombreForm, Image icono) {
        super();
        try {
            this.RutaForm = RutaForm;
            this.Loader = new FXMLLoader(this.RutaForm).load();
            this.RaizForm = this.Loader.load();
            this.IconoVentana = icono;
            getIcons().add(this.IconoVentana);
            setScene(new Scene(this.RaizForm));
            setTitle(NombreForm);
        } catch (IOException ex) {

        }
    }

    public FXMLLoader getLoader() {
        return Loader;
    }

    public void setLoader(FXMLLoader Loader) {
        this.Loader = Loader;
    }

    public void setExitOnEscape(boolean activar) {
        if (activar) {
            this.getScene().addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode() == KeyCode.ESCAPE) {
                        ControlVentana.this.close();
                        event.consume();
                    }
                }
            });

        }
    }

}
