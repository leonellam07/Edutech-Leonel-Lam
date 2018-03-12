package com.javaee.finaltest.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javax.jms.Message;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class FXMLController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        GET2();
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    public void GET2() {
        Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs-06/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
		Message message1 = singleMessageTarget
				.resolveTemplate("messageId", "1")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		Message message2 = singleMessageTarget
				.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		Message newMessage = new Message(4, "My New message from JAX-RS client", "koushik") {};
		Response postResponse = messagesTarget
			.request()
			.post(Entity.json(newMessage));
		if (postResponse.getStatus() != 201) {
			System.out.println("Error");
		}
		Message createdMessage = postResponse.readEntity(Message.class);
		System.out.println(createdMessage.getMessage());

    }

    public void GET() {

        try {

            URL url = new URL("http://localhost:8081/finaltest/api/clientes");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
