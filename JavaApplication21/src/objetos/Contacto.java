/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

import java.io.Serializable;

/**
 *
 * @author santa
 */
public class Contacto implements Comparable<Contacto>, Serializable{
    private String nombre;
    private String empresa;
    private String correo;

    public Contacto(String nombre, String empresa, String correo) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.correo = correo;
    }

    @Override
    public int compareTo(Contacto o) {
        return this.nombre.compareTo(o.getNombre());
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre +  ", empresa=" + empresa +   ", correo=" + correo + '}';
    }


    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    



    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

   
    
    
    
}
