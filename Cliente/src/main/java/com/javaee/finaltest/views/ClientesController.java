/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaee.finaltest.views;

import com.javaee.finaltest.dto.Cliente;
import com.javaee.finaltest.dto.Departamento;
import com.javaee.finaltest.dto.Municipio;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 * FXML Controller class
 *
 * @author leolp
 */
public class ClientesController implements Initializable {

    @FXML
    private Button btnGuardar;
    @FXML
    private TableView<Cliente> tblClientes;
    @FXML
    private ComboBox<Departamento> cmbDepartamentos;
    @FXML
    private ComboBox<Municipio> cmbMunicipios;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtNit;
    @FXML
    private DatePicker dtpFechaNacimiento;

    @FXML
    private void eventDepartamento(ActionEvent event) throws IOException {
        if (cmbMunicipios.isDisable()) {
            cmbMunicipios.setDisable(false);
        }
        cmbMunicipios.getItems().clear();
        cmbMunicipios.getItems().addAll(cmbDepartamentos.getValue().getMunicipios());

    }

    @FXML
    private void eventGuardar() {
        Client client = ClientBuilder.newClient();
        try {
            LocalDate localDate = dtpFechaNacimiento.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date fechaNacimiento = Date.from(instant);

            Cliente nuevoCliente = new Cliente(
                    txtNombre.getText().trim(),
                    txtDireccion.getText().trim(),
                    new Municipio(cmbMunicipios.getValue().getId(), null, null, null),
                    txtNit.getText(),
                    fechaNacimiento
            );

            WebTarget target = client.target("http://localhost:8081/finaltest/api/clientes");
            Cliente saved = target.path("create").request()
                    .post(Entity.entity(nuevoCliente, MediaType.APPLICATION_JSON), Cliente.class);

            if (saved != null) {
                System.out.println("cliente guardado: " + saved.getId() + ", " + saved.getNombre());
                cargarClientes();
            } else {
                System.out.println("No se pudo guardar cliente");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            client.close();
        }
    }

    private void cargarClientes() {
        try {
            Client client = ClientBuilder.newClient();
            List<Cliente> lista = new LinkedList<>();
            lista = client.target("http://localhost:8081/finaltest/api/clientes")
                    .request(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<Cliente>>() {
                    });

            for (Cliente cliente : lista) {
                System.out.println(cliente.getNombre() + " " + cliente.getDireccion());
            }

            tblClientes.getItems().addAll(lista);
            tblClientes.setPlaceholder(new Label("No se encontraron registros disponibles."));
            client.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarClientes();
        tblClientes.getColumns().add(new ColumnaId());
        tblClientes.getColumns().add(new ColumnaNombre());
        tblClientes.getColumns().add(new ColumnaDireccion());
        tblClientes.getColumns().add(new ColumnaMunicipio());

        try {
            Client client = ClientBuilder.newClient();
            List<Departamento> lista = new LinkedList<>();
            lista = client.target("http://localhost:8081/finaltest/api/departamentos")
                    .request(MediaType.APPLICATION_JSON)
                    .get(new GenericType<List<Departamento>>() {
                    });

            for (Departamento departamento : lista) {
                System.out.println(departamento.getCodigo() + " " + departamento.getNombre());
            }

            cmbDepartamentos.getItems().addAll(lista);
            cmbDepartamentos.setPlaceholder(new Label("No se encontraron registros disponibles."));
            client.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private class ColumnaId extends TableColumn<Cliente, String> {

        public ColumnaId() {
            super("ID");
            super.setCellValueFactory(new PropertyValueFactory<Cliente, String>("id"));
            super.setPrefWidth(20);
        }
    }

    private class ColumnaDireccion extends TableColumn<Cliente, String> {

        public ColumnaDireccion() {
            super("Direccion");
            super.setCellValueFactory(new PropertyValueFactory<Cliente, String>("direccion"));
            super.setPrefWidth(100);
        }
    }

    private class ColumnaNombre extends TableColumn<Cliente, String> {

        public ColumnaNombre() {
            super("Nombre");
            super.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
            super.setPrefWidth(100);
        }
    }

    private class ColumnaMunicipio extends TableColumn<Cliente, String> {

        public ColumnaMunicipio() {
            super("Municipio");
            super.setCellValueFactory(new PropertyValueFactory<Cliente, String>("muni"));
            super.setPrefWidth(100);
        }
    }
//
//    private class ColumnaModificar extends TableColumn<Cliente, Boolean> {
//
//        public ColumnaModificar() {
//            super("Modificar");
//            super.setStyle("-fx-alignment:center;");
//            super.setMaxWidth(60);
//            super.setSortable(false);
//            super.setResizable(false);
//            super.setCellValueFactory(new Callback<CellDataFeatures<Cliente, Boolean>, ObservableValue<Boolean>>() {
//
//                @Override
//                public ObservableValue<Boolean> call(CellDataFeatures<Cliente, Boolean> param) {
//                    return new SimpleBooleanProperty(param.getValue() != null);
//                }
//            });
//            super.setCellFactory(new Callback<TableColumn<Cliente, Boolean>, TableCell<Cliente, Boolean>>() {
//                @Override
//                public TableCell<Cliente, Boolean> call(TableColumn<Cliente, Boolean> param) {
//                    return new CeldasModificar();
//                }
//            });
//        }
//
//        private class CeldasModificar extends TableCell<Cliente, Boolean> {
//
//            final Button btnModificar = new Button();
//
//            CeldasModificar() {
//
//                btnModificar.setOnAction(new EventHandler<ActionEvent>() {
//
//                    @Override
//                    public void handle(ActionEvent event) {
//
//                    }
//                }
//                );
//            }
//
//            @Override
//            protected void updateItem(Boolean t, boolean empty) {
//                super.updateItem(t, empty);
//                if (!empty) {
//                    setGraphic(btnModificar);
//                } else {
//                    setText(null);
//                    setGraphic(null);
//                }
//            }
//        }
//
//    }
//
//    private class ColumnaEliminar extends TableColumn<Cliente, Boolean> {
//
//        public ColumnaEliminar() {
//            super("Eliminar");
//            super.setStyle("-fx-alignment:center;");
//            super.setMaxWidth(60);
//            super.setSortable(false);
//            super.setResizable(false);
//            super.setCellValueFactory(new Callback<CellDataFeatures<Cliente, Boolean>, ObservableValue<Boolean>>() {
//
//                @Override
//                public ObservableValue<Boolean> call(CellDataFeatures<Cliente, Boolean> param) {
//                    return new SimpleBooleanProperty(param.getValue() != null);
//                }
//            });
//            super.setCellFactory(new Callback<TableColumn<Cliente, Boolean>, TableCell<Cliente, Boolean>>() {
//
//                @Override
//                public TableCell<Cliente, Boolean> call(TableColumn<Cliente, Boolean> param) {
//                    return new CeldasEliminar();
//                }
//            });
//        }
//
//        private class CeldasEliminar extends TableCell<Cliente, Boolean> {
//
//            final Button btnEliminar = new Button("Eliminar");
//
//            public CeldasEliminar() {
//                btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent event) {
//                        Client client = ClientBuilder.newClient();
//                        Cliente respuesta = client.target("http://localhost:8081/finaltest/api/clientes")
//                                .request(MediaType.APPLICATION_JSON)
//                                .delete(Cliente.class);
//
//                    }
//                });
//            }
//
//            @Override
//            protected void updateItem(Boolean t, boolean empty) {
//                super.updateItem(t, empty);
//                if (!empty) {
//                    setGraphic(btnEliminar);
//                } else {
//                    setText(null);
//                    setGraphic(null);
//                }
//            }
//        }
//
//    }
}
