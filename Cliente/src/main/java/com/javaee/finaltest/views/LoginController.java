/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaee.finaltest.views;

import com.javaee.finaltest.controls.ControlVentana;
import com.javaee.finaltest.dto.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * FXML Controller class
 *
 * @author leolp
 */
public class LoginController implements Initializable {

    private static final String WS_URI = "http://localhost:8081/finaltest/api/usuarios/{user}";

    @FXML
    private Button btnIniciarSesion;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField pswPassword;
    
    @FXML
    private void IniciarSesion(ActionEvent event) {
        Client client = ClientBuilder.newClient();
        try {
            WebTarget wbtarget = client.target(WS_URI);
            Usuario user = wbtarget
                    .resolveTemplate("user", txtUsuario.getText().trim())
                    .request(MediaType.APPLICATION_JSON)
                    .get(Usuario.class);
            if (user.getPassword().equals(pswPassword.getText().trim())) {
                ControlVentana ventana = new ControlVentana(getClass().getResource("/fxml/Menu.fxml"), "Menú Principal");
                ventana.initModality(Modality.WINDOW_MODAL);
                ventana.setMaximized(true);
                ventana.show();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
