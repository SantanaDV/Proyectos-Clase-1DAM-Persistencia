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
import persistencia.PersistenciaJDBC;

/**
 *
 * @author santa
 */
public class Interfaz {
    public static void main(String[] args) {
        Persistencia  p1 = new PersistenciaFicherosTexto("ficheroTexto.txt");
        Persistencia p2 = new PersistenciaFicheroBinario("ficheroBinario1.bin");
        Persistencia p3 = new PersistenciaJDBC("programacionAlumnos", "localhost", "3306", "root", "root127!", "alumnos");
        
        ArrayList<Alumno> lineas = new ArrayList<>();
        ArrayList<Alumno> alumnos = new ArrayList<>();
        
        alumnos.add(new Alumno("Pepe", "Julianes", "Ingles", "2022-08-19", true));
        alumnos.add(new Alumno("Rufian", "Farfeño", "NeoZelandes", "2010-01-22", false));
        /*System.out.println("TXT Guardando, imprimiendo lineas de fichero de texto");
        p1.guardarDatos(alumnos);
        lineas.clear();
        lineas =p2.cargarDatos();
        System.out.println(lineas);
        lineas.clear();
         lineas = p1.cargarDatos();
         System.out.println(lineas);
          System.out.println("BIN Guardando, imprimiendo lineas de fichero de texto");
        p2.guardarDatos(alumnos);
        alumnos.clear();
         alumnos = p2.cargarDatos();
         System.out.println(alumnos);*/
         System.out.println("Probando JBDC");
         lineas = p3.cargarDatos();
         
         for (Alumno l : lineas) {
             System.out.println(l);
        }
        p3.guardarDatos(alumnos);
        lineas.clear();
        
        lineas = p3.cargarDatos();
        for (Alumno l : lineas) {
            System.out.println(l);
        }
        
         
    }
    
}
