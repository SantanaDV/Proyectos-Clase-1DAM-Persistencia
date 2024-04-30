/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;


import java.util.ArrayList;
import java.util.Arrays;
import objetos.Alumno;
import persistencia.Persistencia;
import persistencia.PersistenciaFicheroBinario;
import persistencia.PersistenciaFicherosTexto;

/**
 *
 * @author santa
 */
public class Interfaz {
    public static void main(String[] args) {
        Persistencia  p1 = new PersistenciaFicherosTexto("ficheroTexto.txt");
        Persistencia <Alumno> p2 = new PersistenciaFicheroBinario("ficheroBinario1.bin");
        
        ArrayList<String> lineas = new ArrayList<>();
        ArrayList<Alumno> alumnos = new ArrayList<>();
        
        lineas.addAll(Arrays.asList("Nueva linea para el fichero", "Otra linea mas"));
        alumnos.add(new Alumno(101,"Jorge", "Hola S.L", "blabla@gmail.com","mamams"));
        alumnos.add(new Alumno(102,"Pepe", "Hola S.L", "blabla@gmail.com","hdasjna"));
        System.out.println("TXT Guardando, imprimiendo lineas de fichero de texto");
        p1.guardarDatos(alumnos);
        lineas.clear();
         lineas = p1.cargarDatos();
         System.out.println(lineas);
          System.out.println("BIN Guardando, imprimiendo lineas de fichero de texto");
        p2.guardarDatos(alumnos);
        alumnos.clear();
         alumnos = p2.cargarDatos();
         System.out.println(alumnos);
        
         
        Alumno a = new Alumno(0, nombre, apellidos, nacionalidad, fechaNacimiento, true)
    }
    
}
