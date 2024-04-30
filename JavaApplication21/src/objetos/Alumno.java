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
public class Alumno implements Comparable<Alumno>, Serializable {

    private int id;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private String fechaNacimiento;
    private boolean sexo;

    public Alumno( String nombre, String apellidos, String nacionalidad, String fechaNacimiento, boolean sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public Alumno(int id, String nombre, String apellidos, String nacionalidad, String fechaNacimiento, boolean sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }
    

    @Override
    public int compareTo(Alumno o) {
        return this.nombre.compareTo(o.getNombre());
    }

    @Override
    public String toString() {
        
        return  this.id + "," + this.nombre + "," + this.apellidos + "," + nacionalidad + "," + this.fechaNacimiento + "," + MasculinoOFemenino(this.sexo) ;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    
    public String MasculinoOFemenino(boolean sexo){
        
        return (sexo)? "masculino":"femenino";
    }
    
}
