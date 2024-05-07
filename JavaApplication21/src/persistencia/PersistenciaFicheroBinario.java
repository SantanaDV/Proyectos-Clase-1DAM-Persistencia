/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import objetos.Alumno;

/**
 *
 * @author santa
 */
public final class PersistenciaFicheroBinario extends PersistenciaFichero{

    public PersistenciaFicheroBinario(String rutaFichero) {
        super(rutaFichero);
    }

    @Override
    public ArrayList<Alumno> cargarDatos() {
                    ArrayList<Alumno> salida = new ArrayList<>();
        try {
            File archivoBinario = new File(rutaFichero);
            FileInputStream file = new FileInputStream(archivoBinario);
            ObjectInputStream oIS= new ObjectInputStream(file);

          
                
                  salida = ((ArrayList<Alumno>)oIS.readObject());

              
            file.close();
            oIS.close();
            return salida;
           
            
        

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return salida;
    }

    @Override
    public void guardarDatos(ArrayList<Alumno> datos) {
        try {
            File archivoBinario = new File(rutaFichero);
            FileOutputStream flujoSalida = new FileOutputStream(archivoBinario, false);
            ObjectOutputStream os = new ObjectOutputStream(flujoSalida);
            os.writeObject(datos);
            flujoSalida.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
