package Controladores;

import ConnectMySQL.ConnectarDB;
import Modelos.Inventario;
import Modelos.Proveedores;
import Modelos.Trabajadores;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class MenuController implements Initializable {

    ///Tabla de Inventario
    @FXML
    private TableColumn<Inventario, String> codProducColum;
    @FXML
    private TableColumn<Inventario, String> descripcionColum;
    @FXML
    private TableColumn<Inventario, String> existenciasColum;
    @FXML
    private TableView<Inventario> tablaAlmacen;

    private ObservableList<Inventario> listaInventario;

    @FXML
    private TextField codTXT;
    @FXML
    private TextField desTXT;
    @FXML
    private TextField exisTXT;

    ///Tabla de Trabajadores
    @FXML
    private TableView<Trabajadores> departTable;
    @FXML
    private TableColumn<Trabajadores, String> dniColum;
    @FXML
    private TableColumn<Trabajadores, String> nombreColum;
    @FXML
    private TableColumn<Trabajadores, String> apellidosColum;
    @FXML
    private TableColumn<Trabajadores, String> direcColum;
    @FXML
    private TableColumn<Trabajadores, String> departColum;

    private TableColumn<Trabajadores, String> isbnColum;

    private ObservableList<Trabajadores> listDepart;
    @FXML
    private TextField dniTXT;
    @FXML
    private TextField nombreTXT;
    @FXML
    private TextField apellidosTXT;
    @FXML
    private TextField direccionTXT;
    @FXML
    private TextField departTXT;
    private TextField isbnTXT;
    @FXML
    private Button btneliminar;

    ///Tabla de Ptoveedores
    @FXML
    private TableView<Proveedores> tablaProveedores;

    private ObservableList<Proveedores> listProvv;

    @FXML
    private TableColumn<Proveedores, String> correoColum;
    @FXML
    private TableColumn<Proveedores, String> direccionColum1;
    @FXML
    private TableColumn<Proveedores, String> tlfcolum;
    @FXML
    private TableColumn<Proveedores, String> nombreProColum;

    @FXML
    private TextField correosProvTXT;
    @FXML
    private TextField tlfProvTXT;
    @FXML
    private TextField direccionProvTXT;
    @FXML
    private TextField nombProvTXT;

    Stage stage;
    String query;
    Connection conn;
    private ConnectarDB connectDB = null;
    PreparedStatement prepare = null;
    ResultSet result = null;
    Inventario inventario;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connectDB = new ConnectarDB();
        cargarDatosAlmacen();
        cargarDAtosEmpleados();
        cargarDatosProveedores();

    }

    private void cargarDatosAlmacen() {

        try {
            listaInventario = FXCollections.observableArrayList();

            query = "SELECT * FROM almacen";
            conn = ConnectarDB.ConnectionDB();
            result = conn.createStatement().executeQuery(query);
            while (result.next()) {
                Inventario invent = new Inventario();
                invent.setCodigop(result.getString("codigop"));
                invent.setDescripcion(result.getString("descripcion"));
                invent.setExistencias(result.getString("existencias"));

                listaInventario.add(invent);
            }

            codProducColum.setCellValueFactory(new PropertyValueFactory<>("codigop"));
            descripcionColum.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
            existenciasColum.setCellValueFactory(new PropertyValueFactory<>("existencias"));

            tablaAlmacen.setItems(listaInventario);
        } catch (Exception e) {

        }

    }

    private void cargarDAtosEmpleados() {
        try {
            listDepart = FXCollections.observableArrayList();

            query = " SELECT * FROM trabajadores";
            conn = ConnectarDB.ConnectionDB();
            result = conn.createStatement().executeQuery(query);
            while (result.next()) {
                Trabajadores trabajadores = new Trabajadores();
                trabajadores.setDni(result.getString("dni"));
                trabajadores.setNombre(result.getString("nombre"));
                trabajadores.setApellidos(result.getString("apellidos"));
                trabajadores.setDireccion(result.getString("direccion"));
                trabajadores.setNumdepart(result.getString("numdepart"));

                listDepart.add(trabajadores);

            }

            
            dniColum.setCellValueFactory(new PropertyValueFactory<>("dni"));
            nombreColum.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            apellidosColum.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
            direcColum.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            departColum.setCellValueFactory(new PropertyValueFactory<>("numdepart"));

            departTable.setItems(listDepart);

        } catch (Exception e) {
        }

    }

    private void cargarDatosProveedores() {
        try {
            listProvv = FXCollections.observableArrayList();

            query = " SELECT * FROM proveedores";
            conn = ConnectarDB.ConnectionDB();
            result = conn.createStatement().executeQuery(query);
            while (result.next()) {
                Proveedores provs = new Proveedores();

                provs.setNombreProv(result.getString("nombre"));
                provs.setDireccionProv(result.getString("direccion"));
                provs.setTLFProv(result.getString("telefono"));
                provs.setCorreoProv(result.getString("correo"));

                listProvv.add(provs);

            }
            nombreProColum.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            direccionColum1.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            tlfcolum.setCellValueFactory(new PropertyValueFactory<>("telefono"));
            correoColum.setCellValueFactory(new PropertyValueFactory<>("correo"));

            tablaProveedores.setItems(listProvv);

        } catch (Exception e) {
        }

    }

    @FXML
    private void addItem(ActionEvent event) {

        String sql = "insert into almacen(codigop,descripcion,existencias)values(?,?,?)";
        try {
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, codTXT.getText());
            prepare.setString(2, desTXT.getText());
            prepare.setString(3, exisTXT.getText());

            prepare.execute();
            JOptionPane.showMessageDialog(null, "Elemento añadido a Inventario");

            cleanItem();
            cargarDatosAlmacen();

        } catch (HeadlessException | SQLException e) {
        }
    }

    @FXML
    private void addWorker(ActionEvent event) {

        String sql = " insert into trabajadores(dni, nombre, apellidos, direccion, numdepart) values (?,?,?,?,?) ";
        try {
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, dniTXT.getText());
            prepare.setString(2, nombreTXT.getText());
            prepare.setString(3, apellidosTXT.getText());
            prepare.setString(4, direccionTXT.getText());
            prepare.setString(5, departTXT.getText());

            prepare.execute();

            JOptionPane.showMessageDialog(null, "Trabajador añadido a la base");

            cleanWorker();
            cargarDAtosEmpleados();

        } catch (Exception e) {
        }

    }

    @FXML
    private void addProv(ActionEvent event) {
        String sql = " insert into proveedores(nombre, direccion, telefono, correo) values (?,?,?,?) ";
        try {
            prepare = conn.prepareStatement(sql);
            prepare.setString(1, nombProvTXT.getText());
            prepare.setString(2, direccionProvTXT.getText());
            prepare.setString(3, tlfProvTXT.getText());
            prepare.setString(4, correosProvTXT.getText());

            prepare.execute();

            JOptionPane.showMessageDialog(null, "Proveedor añadido");

            cleanProv();
            cargarDatosProveedores();

        } catch (Exception e) {
        }

    }

    private void cleanItem() {
        codTXT.setText(null);
        desTXT.setText(null);
        exisTXT.setText(null);

    }

    private void cleanWorker() {

        dniTXT.setText(null);
        nombreTXT.setText(null);
        apellidosTXT.setText(null);
        direccionTXT.setText(null);
        departTXT.setText(null);

    }

    private void cleanProv() {

        nombProvTXT.setText(null);
        correosProvTXT.setText(null);
        direccionProvTXT.setText(null);
        tlfProvTXT.setText(null);

    }

    @FXML
    private void closeMenu(ActionEvent event) {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void deleteItem(ActionEvent event) {

        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Vista/EliminarItem.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void deleteWorker(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Vista/EliminarWorker.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void deleteProv(ActionEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Vista/EliminarProv.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
