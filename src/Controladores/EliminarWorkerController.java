/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controladores;

import ConnectMySQL.ConnectarDB;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author elman
 */
public class EliminarWorkerController implements Initializable {
    
    Stage stage;
    String query;
    Connection conn;
    private ConnectarDB connectDB = null;
    PreparedStatement prepare = null;
    ResultSet result = null;

    @FXML
    private JFXTextField workerDeleteTXT;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void delete(ActionEvent event) {
        try {
            
            query = "delete from trabajadores where dni = '" + workerDeleteTXT.getText() + "'";
            
            System.out.println(query);
            conn = ConnectarDB.ConnectionDB();
            prepare = conn.prepareStatement(query);
            prepare.execute();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
