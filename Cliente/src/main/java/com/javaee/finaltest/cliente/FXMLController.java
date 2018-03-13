package com.javaee.finaltest.cliente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.List;
import com.javaee.finaltest.dto.Cliente;
import com.javaee.finaltest.dto.Municipio;
import java.util.Date;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

public class FXMLController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        System.out.println("You clicked me!");
        label.setText("Hello World!");

        loginUser();
        insertarUsuario();
    }

    public void insertarUsuario() {
        Client client = ClientBuilder.newClient();
        try {
            Cliente nuevoCliente = new Cliente(
                    "LeoKira",
                    "Zona 6 de Mixco",
                    new Municipio(2, null, null, null),
                    "123123132",
                    new Date()
            );

            WebTarget target = client.target("http://localhost:8081/finaltest/api/clientes");
            Cliente saved = target.path("create").request()
                    .post(Entity.entity(nuevoCliente, MediaType.APPLICATION_JSON), Cliente.class);

            System.out.println("cliente guardado: " + saved.getId() + ", " + saved.getNombre());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            client.close();
        }
    }

    public void loginUser() {
        System.out.println("test");
        Client client = ClientBuilder.newClient();
        try {

//LoginDto inputDto = new LoginDto();
//        inputDto.setUsuario("admin");
//        inputDto.setClave("holamundo");
            //client.queryParam("idUsuario", "admin")
            //LoginDto userDto = 
            List<Cliente> lista = client.target("http://localhost:8081/finaltest/api/clientes")
                    .request(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<Cliente>>() {
                    });

            for (Cliente cliente : lista) {
                System.out.println(cliente.getNombre() + " " + cliente.getDireccion());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

//                .post(Entity.entity(inputDto, MediaType.APPLICATION_JSON), LoginDto.class);
//        assert (userDto.getExito());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
