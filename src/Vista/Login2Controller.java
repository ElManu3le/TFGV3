/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Vista;

import ConnectMySQL.ConnectarDB;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author elman
 */
public class Login2Controller implements Initializable {

    @FXML
    private JFXButton btnCerrar;
    @FXML
    private JFXTextField userTXT;
    @FXML
    private JFXTextField passwdTXT;

    Stage dialogeStage = new Stage();
    Scene scene;
    Stage stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Login(ActionEvent event) {

        try {

            //Comprueba que se ha iontroducido correctamente la contraseña "admin"
            if (passwdTXT.getText().toString().equals("admin")) {

                
                JOptionPane.showMessageDialog(null, "Bienvenido " + userTXT.getText());

                Parent root = FXMLLoader.load(getClass().getResource("/Vista/Menu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else {
                JOptionPane.showMessageDialog(null, "Parametros introducidos incorrectos");

            }

        } catch (IOException ex) {
            Logger.getLogger(Login2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
