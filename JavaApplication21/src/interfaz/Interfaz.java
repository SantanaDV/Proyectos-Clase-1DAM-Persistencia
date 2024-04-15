/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;


import java.util.ArrayList;
import java.util.Arrays;
import objetos.Contacto;
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
        Persistencia <Contacto> p2 = new PersistenciaFicheroBinario("ficheroBinario1.bin");
        
        ArrayList<String> lineas = new ArrayList<>();
        ArrayList<Contacto> contactos = new ArrayList<>();
        
        lineas.addAll(Arrays.asList("Nueva linea para el fichero", "Otra linea mas"));
        contactos.add(new Contacto("Jorge", "Hola S.L", "blabla@gmail.com"));
        contactos.add(new Contacto("Pepe", "Hola S.L", "blabla@gmail.com"));
        System.out.println("TXT Guardando, imprimiendo lineas de fichero de texto");
        p1.guardarDatos(contactos);
        lineas.clear();
         lineas = p1.cargarDatos();
         System.out.println(lineas);
          System.out.println("BIN Guardando, imprimiendo lineas de fichero de texto");
        p2.guardarDatos(contactos);
        contactos.clear();
         contactos = p2.cargarDatos();
         System.out.println(contactos);
        
         
        
    }
    
}
