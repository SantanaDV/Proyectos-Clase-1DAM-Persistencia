/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author santa
 */
public final class PersistenciaFicheroBinario<T> extends PersistenciaFichero<T> {

    public PersistenciaFicheroBinario(String rutaFichero) {
        super(rutaFichero);
    }

    @Override
    public ArrayList<T> cargarDatos() {
        try {
            File archivoBinario = new File(rutaFichero);
            FileInputStream file = new FileInputStream(archivoBinario);
            ObjectInputStream oIS= new ObjectInputStream(file);
            ArrayList<T> salida = new ArrayList<>();
            while (true) {
                try {
                  salida.add((T) oIS.readObject());

                } catch (EOFException e) {
                    System.out.println("Final");
                    break;
                }
            }
            file.close();
            oIS.close();
            return salida;
           
            
        

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void guardarDatos(ArrayList<T> datos) {
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
