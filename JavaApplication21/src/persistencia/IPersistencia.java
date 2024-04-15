/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.ArrayList;

/**
 *
 * @author santa
 */
public interface IPersistencia <T>{
            ArrayList <T> cargarDatos();
            void guardarDatos(ArrayList <T> datos);
    
            
}
