/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaee.finaltest.controls;

import java.io.IOException;
import java.net.URL;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 *
 * @author JLAM
 */
public class ControladorMdi {

    private static boolean Cerrado = true;
    private static AnchorPane ContenedorMDI;
    private static AnchorPane panel;

    public static boolean isCerrado() {
        return Cerrado;
    }

    public static void setCerrado(boolean aCerrado) {
        Cerrado = aCerrado;
    }

    public ControladorMdi() {

    }

    public ControladorMdi(AnchorPane contenedorMDI) {
        ContenedorMDI = contenedorMDI;
        ContenedorMDI.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.isAltDown() && event.getCode() == KeyCode.F4) {
                    CerrarVentanaHijo();
                }
            }

        });
    }

    public void PrimeraVentana(URL nombreForm) {
        try {
            panel = (AnchorPane) FXMLLoader.load(nombreForm);
            AnchorPane.setBottomAnchor(panel, 0.0);
            AnchorPane.setTopAnchor(panel, 0.0);
            AnchorPane.setLeftAnchor(panel, 0.0);
            AnchorPane.setRightAnchor(panel, 0.0);
            ContenedorMDI.getChildren().setAll(panel);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void CargarVentanaHijo(URL nombreForm) {
        if (ControladorMdi.Cerrado) {
            try {

                panel = (AnchorPane) FXMLLoader.load(nombreForm);
                AnchorPane.setBottomAnchor(panel, 0.0);
                AnchorPane.setTopAnchor(panel, 0.0);
                AnchorPane.setLeftAnchor(panel, 0.0);
                AnchorPane.setRightAnchor(panel, 0.0);
                panel.setVisible(false);
                ContenedorMDI.getChildren().setAll(panel);
                Cerrado = false;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        panel.setVisible(true);
                        TranslateTransition transicion_entrada = new TranslateTransition(Duration.millis(300), panel);
                        transicion_entrada.setCycleCount(1);
                        transicion_entrada.setFromX(panel.getWidth());
                        transicion_entrada.setToX(0);
                        transicion_entrada.play();
                    }
                });
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void CerrarVentanaHijo() {
        TranslateTransition transicion = new TranslateTransition(Duration.millis(300), panel);
        transicion.setCycleCount(1);
        transicion.setAutoReverse(true);
        transicion.setFromX(0);
        transicion.setToX(panel.getWidth());
        transicion.play();
        transicion.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i < ControladorMdi.ContenedorMDI.getChildren().size(); i++) {
                    AnchorPane window = (AnchorPane) ControladorMdi.ContenedorMDI.getChildren().get(i);
                    ControladorMdi.ContenedorMDI.getChildren().remove(i);
                }
                Cerrado = true;
                panel = null;
            }
        });

    }

    public static void SobreponerVentanaHijo(final URL nombreForm) {
        Cerrado = true;
        if (panel != null) {
            TranslateTransition transicion_salida = new TranslateTransition(Duration.millis(300), panel);
            transicion_salida.setCycleCount(1);
            transicion_salida.setAutoReverse(true);
            transicion_salida.setFromX(0);
            transicion_salida.setToX(panel.getWidth());
            transicion_salida.play();
            transicion_salida.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    for (int i = 0; i < ControladorMdi.ContenedorMDI.getChildren().size(); i++) {
                        AnchorPane window = (AnchorPane) ControladorMdi.ContenedorMDI.getChildren().get(i);
                        ControladorMdi.ContenedorMDI.getChildren().remove(i);
                    }
                    try {
                        panel = null;
                        panel = (AnchorPane) FXMLLoader.load(nombreForm);
                        AnchorPane.setBottomAnchor(panel, 0.0);
                        AnchorPane.setTopAnchor(panel, 0.0);
                        AnchorPane.setLeftAnchor(panel, 0.0);
                        AnchorPane.setRightAnchor(panel, 0.0);
                        panel.setVisible(false);
                        ContenedorMDI.getChildren().setAll(panel);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                panel.setVisible(true);
                                TranslateTransition transicion_entrada = new TranslateTransition(Duration.millis(300), panel);
                                transicion_entrada.setCycleCount(1);
                                transicion_entrada.setFromX(panel.getWidth());
                                transicion_entrada.setToX(0);
                                transicion_entrada.play();
                            }
                        });
                    } catch (IOException ex) {
                        Cerrado = false;
                        ex.printStackTrace();
                    }
                }
            });

        } else {
            CargarVentanaHijo(nombreForm);
        }
    }

}
