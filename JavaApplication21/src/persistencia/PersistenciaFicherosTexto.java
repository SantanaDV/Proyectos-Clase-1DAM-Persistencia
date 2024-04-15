/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author santa
 */
public final class PersistenciaFicherosTexto<T> extends PersistenciaFichero<T>{

    public PersistenciaFicherosTexto(String rutaFichero) {
        super(rutaFichero);
    }

    @Override
    public ArrayList<T> cargarDatos() {
        try {
            File archivoTexto = new File(rutaFichero);
            FileReader archivoTextoLectura = new FileReader(archivoTexto);
            BufferedReader bf = new BufferedReader(archivoTextoLectura);
            String linea;
            ArrayList <T> datos = new ArrayList<>();
            
             while ((linea =  bf.readLine()) != null) {
                 String arrayLinea [] = linea.split(",");
                 for (String dato : arrayLinea) {
                    
                     datos.add((T)dato);
                 }
                
            }
             archivoTextoLectura.close();
             bf.close();
             return  datos;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void guardarDatos(ArrayList<T> datos) {
        
         try {
            File archivoTexto = new File(rutaFichero);
             FileWriter archivoTextoLectura = new FileWriter(archivoTexto);
            PrintWriter bf = new PrintWriter(archivoTextoLectura);
             for (T dato : datos) {
                 bf.println(dato.toString());
             }
             archivoTextoLectura.close();
             bf.close();
             
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
   

   
    
}
