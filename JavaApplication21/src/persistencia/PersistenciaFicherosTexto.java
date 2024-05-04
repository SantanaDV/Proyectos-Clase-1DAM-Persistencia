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
import objetos.Alumno;

/**
 *
 * @author santa
 */
public final class PersistenciaFicherosTexto extends PersistenciaFichero {

    public PersistenciaFicherosTexto(String rutaFichero) {
        super(rutaFichero);
    }

    @Override
    public ArrayList<Alumno> cargarDatos() {
        try {
            File archivoTexto = new File(rutaFichero);
            FileReader archivoTextoLectura = new FileReader(archivoTexto);
            BufferedReader bf = new BufferedReader(archivoTextoLectura);
            String linea;
            ArrayList<Alumno> datos = new ArrayList<>();

            while ((linea = bf.readLine()) != null) {
                String arrayLinea[] = linea.split(",");
                datos.add(trocearDatos(arrayLinea));

            }
            archivoTextoLectura.close();
            bf.close();
            return datos;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void guardarDatos(ArrayList<Alumno> datos) {

        try {
            File archivoTexto = new File(rutaFichero);
            FileWriter archivoTextoLectura = new FileWriter(archivoTexto);
            PrintWriter bf = new PrintWriter(archivoTextoLectura);
            for (Alumno dato : datos) {
                bf.println(dato.toString());
            }
            archivoTextoLectura.close();
            bf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Alumno trocearDatos(String[] linea) {
        int id;
        String nombre;
        String apellidos;
        String nacionalidad;
        String fechaNacimiento;
        boolean sexo;

        id = Integer.parseInt(linea[0]);
        nombre = (linea[1]);
        apellidos = (linea[2]);
        nacionalidad = (linea[3]);
        fechaNacimiento = (linea[4]);
        if (linea[5].equalsIgnoreCase("masculino")) {
            sexo = true;
        } else {
            sexo = false;
        }
        Alumno alumno = new Alumno(id,nombre, apellidos, nacionalidad, fechaNacimiento, sexo);
        return alumno;

    }

}
