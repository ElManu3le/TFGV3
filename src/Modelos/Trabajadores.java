package Modelos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author elman
 */
public class Trabajadores {

    private final StringProperty dni = new SimpleStringProperty();
    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty apellidos = new SimpleStringProperty();
    private final StringProperty direccion = new SimpleStringProperty();
    private final StringProperty numdepart = new SimpleStringProperty();
    private final StringProperty isbn = new SimpleStringProperty();

    public String getIsbn() {
        return isbn.get();
    }

    public void setIsbn(String value) {
        isbn.set(value);
    }

    public StringProperty isbnProperty() {
        return isbn;
    }
    

    public String getNumdepart() {
        return numdepart.get();
    }

    public void setNumdepart(String value) {
        numdepart.set(value);
    }

    public StringProperty numdepartProperty() {
        return numdepart;
    }
    

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String value) {
        direccion.set(value);
    }

    public StringProperty direccionProperty() {
        return direccion;
    }
    

    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(String value) {
        apellidos.set(value);
    }

    public StringProperty apellidosProperty() {
        return apellidos;
    }
    

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String value) {
        nombre.set(value);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }
    

    public String getDni() {
        return dni.get();
    }

    public void setDni(String value) {
        dni.set(value);
    }

    public StringProperty dniProperty() {
        return dni;
    }
    
    
    
}
