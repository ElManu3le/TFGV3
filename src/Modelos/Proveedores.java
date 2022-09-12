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
public class Proveedores {

    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty direccion = new SimpleStringProperty();
    private final StringProperty telefono = new SimpleStringProperty();
    private final StringProperty correo = new SimpleStringProperty();

    public String getCorreo() {
        return correo.get();
    }

    public String getTelefono() {
        return telefono.get();
    }

    public String getDireccion() {
        return direccion.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombreProv(String values) {
        nombre.set(values);

    }

    public void setDireccionProv(String values) {
        direccion.set(values);

    }

    public void setTLFProv(String values) {
        telefono.set(values);

    }

    public void setCorreoProv(String values) {
        correo.set(values);

    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public StringProperty direccionProperty() {
        return direccion;
    }

    public StringProperty telefonoProperty() {
        return telefono;
    }

    public StringProperty correoProperty() {
        return correo;
    }

}
