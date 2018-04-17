/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaee.finaltest.views;

import java.net.URL;
import java.util.ResourceBundle;
import javaee.finaltest.images.urlImages;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author leolp
 */
public class ATMController implements Initializable {

    //Elementos y metodos de Fxml
    @FXML
    private AnchorPane pnlContent;

    //Elementos y metodos ocultos 
    private VBox vboxIzquierdo;
    private VBox vboxDerecho;

    //Clases internas 
    private class botonesATM extends Button {

        private final ImageView imgIcon = new ImageView();

        public botonesATM(String text, Image imagen) {
            super(text);

            imgIcon.setImage(imagen);
            imgIcon.setFitWidth(60);
            imgIcon.setFitHeight(60);
            imgIcon.setPreserveRatio(true);

            this.setGraphic(imgIcon);
            this.setMinWidth(300);
            this.setMinHeight(60);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botonesATM btnConsultar = new botonesATM("Consultar", urlImages.consulta());
        btnConsultar.setAlignment(Pos.TOP_LEFT);

        botonesATM btnDepositar = new botonesATM("Depositar", urlImages.depositar());
        btnDepositar.setAlignment(Pos.TOP_LEFT);

        botonesATM btnRetirar = new botonesATM("Retirar", urlImages.debitar());
        btnRetirar.setAlignment(Pos.TOP_LEFT);

        botonesATM btnTransferir = new botonesATM("Transferir", urlImages.transferir());
        btnTransferir.setAlignment(Pos.TOP_LEFT);

        botonesATM btnCancelar = new botonesATM("Cancelar", urlImages.cancelar());
        btnCancelar.setAlignment(Pos.CENTER_RIGHT);
        btnCancelar.setContentDisplay(ContentDisplay.RIGHT);

        vboxIzquierdo = new VBox(btnConsultar, btnDepositar, btnRetirar, btnTransferir);
        vboxIzquierdo.setAlignment(Pos.TOP_LEFT);
        vboxIzquierdo.setSpacing(35);

        vboxDerecho = new VBox(btnCancelar);
        vboxDerecho.setAlignment(Pos.TOP_LEFT);
        vboxDerecho.setSpacing(35);

        pnlContent.getChildren().add(vboxIzquierdo);
        pnlContent.getChildren().add(vboxDerecho);

        AnchorPane.setLeftAnchor(vboxIzquierdo, 0.0);
        AnchorPane.setBottomAnchor(vboxIzquierdo, 0.0);
        AnchorPane.setTopAnchor(vboxIzquierdo, 25.0);

        AnchorPane.setRightAnchor(vboxDerecho, 0.0);
        AnchorPane.setBottomAnchor(vboxDerecho, 0.0);
        AnchorPane.setTopAnchor(vboxDerecho, 25.0);

    }

}
