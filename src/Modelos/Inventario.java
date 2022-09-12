/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author elman
 */
public class Inventario {

    private final StringProperty codigop = new SimpleStringProperty();
    private final StringProperty descripcion = new SimpleStringProperty();
    private final StringProperty existencias = new SimpleStringProperty();

    public String getExistencias() {
        return existencias.get();
    }

    public void setExistencias(String value) {
        existencias.set(value);
    }

    public StringProperty existenciasProperty() {
        return existencias;
    }
    

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String value) {
        descripcion.set(value);
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }
    

    public String getCodigop() {
        return codigop.get();
    }

    public void setCodigop(String value) {
        codigop.set(value);
    }

    public StringProperty codigopProperty() {
        return codigop;
    }

   

}
