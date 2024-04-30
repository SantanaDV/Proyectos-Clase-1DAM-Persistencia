/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import objetos.Alumno;

/**
 *
 * @author santa
 */
public final class PersistenciaJDBC extends Persistencia {

    private Connection conexion_;
    private String nombreBD;
    private String ip;
    private String puerto;
    private String usuario;
    private String contrasena_;
    private String url_;
    private String tabla;

    public PersistenciaJDBC(String nombreBD, String ip, String puerto, String usuario, String contrasena_, String url_, String tabla) {
        this.usuario = usuario;
        this.contrasena_ = contrasena_;
        this.url_ = this.url_ = "jdbc:mysql://" + this.ip + ":" + this.puerto + "/" + this.nombreBD;
        this.tabla = tabla;
    }

    public Connection getConexion_() {
        return conexion_;
    }

    public void setConexion_(Connection conexion_) {
        this.conexion_ = conexion_;
    }

    public String getNombreBD() {
        return nombreBD;
    }

    public void setNombreBD(String nombreBD) {
        this.nombreBD = nombreBD;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena_() {
        return contrasena_;
    }

    public void setContrasena_(String contrasena_) {
        this.contrasena_ = contrasena_;
    }

    public String getUrl_() {
        return url_;
    }

    public void setUrl_(String url_) {
        this.url_ = url_;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    @Override
    public String toString() {
        return "PersistenciaJDBC{, nombreBD=" + nombreBD + ", ip=" + ip + ", puerto=" + puerto + ", usuario=" + usuario + ", contrasena_=" + contrasena_ + ", url_=" + url_ + ", tabla=" + tabla + '}';
    }

    @Override
    public ArrayList<Alumno> cargarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardarDatos(ArrayList<Alumno> datos) {
        try {
            abrirConexion();
            
            String sql = "INSERT INTO alumnos (id, nombre,apellidos,nacionalidad,fechaNacimiento,sexo) VALUES (?,?,?,?,?,?)";
                         PreparedStatement ps =this.conexion_.prepareStatement(sql);
            for (Alumno dato : datos) {
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        cerrarConexion();

    }

    public void abrirConexion() {
        try {
            this.conexion_ = DriverManager.getConnection(this.url_, this.usuario, this.contrasena_);
            System.out.println("Conexion exitosa");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            this.conexion_.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
