/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.ArrayList;
import objetos.Alumno;

/**
 *
 * @author santa
 * @param <Alumno>
 */
public interface IPersistencia {
            ArrayList <Alumno> cargarDatos();
            void guardarDatos(ArrayList <Alumno> datos);
    
            
}
