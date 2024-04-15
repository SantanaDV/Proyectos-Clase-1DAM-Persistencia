/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.ArrayList;

/**
 *
 * @author santa
 */
public abstract class PersistenciaFichero<T> extends Persistencia<T>{
   protected String rutaFichero;

    public PersistenciaFichero(String rutaFichero) {
        this.rutaFichero = rutaFichero;
    }

   
    
/*
    @Override
    public ArrayList<T> cargarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardarDatos(ArrayList<T> datos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

*/

    public String getRutaFichero() {
        return rutaFichero;
    }

    public void setRutaFichero(String rutaFichero) {
        this.rutaFichero = rutaFichero;
    }
    
   
}
