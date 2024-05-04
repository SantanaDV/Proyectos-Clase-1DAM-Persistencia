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

    // En el constructor construimos la url en funcion de los atributos que se pasan al objeto
    public PersistenciaJDBC(String nombreBD, String ip, String puerto, String usuario, String contrasena_, String tabla) {
        this.puerto = puerto;
        this.ip = ip;
        this.nombreBD = nombreBD;
        this.usuario = usuario;
        this.contrasena_ = contrasena_;
        this.url_ = "jdbc:mysql://" + ip + ":" + puerto + "/" + nombreBD;
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

    
    //Metodo sobrescrito para cargar datos, una senecia SQL que selecciona todos los datos de la tabla y posteriormente trocea e introduce en una estructura de datos del tipo alumno y devuelve la estructura
    @Override
    public ArrayList<Alumno> cargarDatos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
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
                    boolean sexo = rs.getString("sexo").equalsIgnoreCase("masculino")?true:false;
                    Alumno alumno = new Alumno(id, nombre, apellidos, nacionalidad, fechaNacimiento, sexo);
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

    //Metodo sobreescrito que en funcion de los atributos que necesitamos recoge los datos que le introducimos y los introduce en la tabla como un insert into.
    @Override
    public void guardarDatos(ArrayList<Alumno> datos) {
        try {
            abrirConexion();
            borrar();
            String sql = "INSERT INTO alumnos (id,nombre,apellidos,nacionalidad,fechaNacimiento,sexo) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = this.conexion_.prepareStatement(sql);
            for (Alumno dato : datos) {
                ps.setInt(1, dato.getId());
                ps.setString(2, dato.getNombre());
                ps.setString(3, dato.getApellidos());
                ps.setString(4, dato.getNacionalidad());
                ps.setString(5, dato.getFechaNacimiento());
                ps.setString(6, dato.MasculinoOFemenino(dato.isSexo()));
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

// Metodo que acompaña a los metodos cargarDatos y guardarDatos abriendo la conexión con la BD
    public void abrirConexion() {
        try {
            this.conexion_ = DriverManager.getConnection(this.url_, this.usuario, this.contrasena_);
            System.out.println("Conexion exitosa");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Metodo que acompaña a los metodos cargarDatos y guardarDatos cerrando la conexión con la BD
    public void cerrarConexion() {
        try {
            this.conexion_.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Metodo que borra los datos de la tabla para introducir los nuevos que han  pedido por consola, no tiene el metodo abrir y cerrar conexión porque le llamamos dentro de un metodo abierto que ya cierra la conexión
    //En el caso de que quisieramos sobreescribirlo, tendriamos que solo en el JDBC crear los alumnos sin el id, al ser este autoincremental en la BD, para que no nos diera error.
    public void borrar() {
        try {

            Statement updateStatement = this.conexion_.createStatement();
            updateStatement.executeUpdate("DELETE FROM alumnos");
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }
}
