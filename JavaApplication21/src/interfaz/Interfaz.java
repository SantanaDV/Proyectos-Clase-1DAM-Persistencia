/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
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

    // Menu que devuelve el tipo de Persistencia a trabajar
    static public Persistencia menu() {
        Scanner s = new Scanner(System.in);
        int opciones;
        do {

            System.out.println("Menu Persistencia de datos");
            System.out.println("-------------------------------------");
            System.out.println("Eligue el tipo de persistencia ");
            System.out.println("1- Texto");
            System.out.println("2- Binario");
            System.out.println("3- BD");
            opciones = s.nextInt();

            if (opciones == 1) {
                s.nextLine();
                System.out.println("Dime el nombre del fichero(sin extension): ");
                String fichero = s.nextLine() + ".txt";
                Persistencia p1 = new PersistenciaFicherosTexto(fichero);
                return p1;
            } else if (opciones == 2) {
                      s.nextLine();
                System.out.println("dime el nombre del fichero binario(sin extension):");
                String binario = s.nextLine() + ".bin";
                Persistencia p2 = new PersistenciaFicheroBinario(binario);
                return p2;
            } else if (opciones == 3) {
                      s.nextLine();
                System.out.println("dime el nombre de la BD, la IP, puerto, usuario,  contrasena, y el nombre de la tabla(separado por comas)");
                String datosBD = s.nextLine();
                String[] BDchopeado = datosBD.split(",");
                Persistencia p3 = new PersistenciaJDBC(BDchopeado[0], BDchopeado[1], BDchopeado[2], BDchopeado[3], BDchopeado[4], BDchopeado[5]);
                return p3;
            } else {
                System.out.println("hay solo 3 opciones");
            }
        } while (opciones >= 1 || opciones <= 3);
        return null;
    }

// Este metodo trabaja con la persistencia, al tener metodos comunes, no necesitas ninguna persistencia especifica.
   static public void manejoPersistecia(Persistencia p) {
        Scanner s = new Scanner(System.in);
        ArrayList<Alumno> alumnosGuardarDatos = new ArrayList<>();
        int opcion;
        OUTER:
        do {
            System.out.println("Eligue que quieres hacer con tu Persistencia");
            System.out.println("1- Guardar datos");
            System.out.println("2- Cargar datos");
            System.out.println("3- Salir");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("¿Cuantos alumnos quieres anadir? : ");
                    int alumBuffer = s.nextInt();
                    System.out.println("guardando datos");
                    int alum = alumBuffer;
                    s.nextLine();
                    for (int i = 0; i < alum; i++) {
                      
                        System.out.println("Introduce nombre, apellidos, Nacionalidad, Fecha(ano,mes,dia), sexo (masculino o femenino)");
                        String alumno = s.nextLine();
                        String[] datos = alumno.split(",");
                        Alumno a = new Alumno(i+ 1,datos[0], datos[1], datos[2], datos[3], datos[4].strip().equalsIgnoreCase("masculino")? true:false);
                        
                        alumnosGuardarDatos.add(a);
                    }   p.guardarDatos(alumnosGuardarDatos);
                    System.out.println("Alumnos guardado correctamente");
                    break;
                case 2:
                    System.out.println("Cargando datos");
                    ArrayList<Alumno> alumnoCargarDatos = p.cargarDatos();
                    for (Alumno a : alumnoCargarDatos) {
                        System.out.println(a);
                    }   break;
                case 3:
                    System.out.println("Saliendo...");
                    break OUTER;
                default:
                    System.out.println("Hay solo 3 opciones");
                    break;
            }
        } while (opcion != 3);
    }

   
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int opcion ;
        do {            
            
            System.out.println("Introduce 1 para salir, culquier otro numero para continuar:");
              opcion = s.nextInt();
            if (opcion != 1) {
                 
            manejoPersistecia(menu());
            s.nextLine();
            }else{
                System.out.println("saliendo..");
            }
        
        } while (opcion !=1);
        
     /* 
        
        Datos para conectar a mi base de datos local: 
        
programacionAlumnos,localhost,3306,root,root127!,alumnos
     */

    }

}
