/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public PersistenciaJDBC(String nombreBD, String ip, String puerto, String usuario, String contrasena_, String tabla) {
        this.puerto = puerto;
        this.ip=ip;
        this.nombreBD = nombreBD;
        this.usuario = usuario;
        this.contrasena_ = contrasena_;
        this.url_ = "jdbc:mysql://" +ip + ":" + puerto + "/" + nombreBD;
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
                    ArrayList <Alumno> alumnos = new ArrayList<>();
        try {

            abrirConexion();

            Statement selectStatement = this.conexion_.createStatement();
            ResultSet rs = selectStatement.executeQuery("Select * From alumnos");
            if (!rs.isBeforeFirst()) {
                System.out.println("Sin registros");
            } else {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String apellidos = rs.getString("apellidos");
                    String nacionalidad = rs.getString("nacionalidad");
                    String fechaNacimiento = rs.getString("fechaNacimiento");
                    boolean sexo = MasculinoOFemenino(rs.getString("sexo"));
                   Alumno alumno = new Alumno(id,nombre, apellidos, nacionalidad, fechaNacimiento, sexo);
                   alumnos.add(alumno);
                }
            }
            rs.close();
            selectStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        cerrarConexion();
        return alumnos;
    }

    @Override
    public void guardarDatos(ArrayList<Alumno> datos) {
        try {
            abrirConexion();

            String sql = "INSERT INTO alumnos (nombre,apellidos,nacionalidad,fechaNacimiento,sexo) VALUES (?,?,?,?,?)";
            PreparedStatement ps = this.conexion_.prepareStatement(sql);
            for (Alumno dato : datos) {
                ps.setString(1, dato.getNombre());
                ps.setString(2, dato.getApellidos());
                ps.setString(3, dato.getNacionalidad());
                ps.setString(4, dato.getFechaNacimiento());
                ps.setString(5, dato.MasculinoOFemenino(dato.isSexo()));
                ps.addBatch();
            }

            int[] filasAfectadas = ps.executeBatch();

            System.out.println("Cantidad de alumnos anadidos: " + filasAfectadas.length);
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        cerrarConexion();

    }
    
     public boolean MasculinoOFemenino(String sexo){
        
         if (sexo.equalsIgnoreCase("masculino")) {
             return true;
         }else{
             return false;
         }
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
