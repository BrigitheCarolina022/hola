package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String bbdd="jdbc:mysql://localhost:3306/Bolsillo";
    private static final String Usuarios="root";
    private static final String clave="";
    private static Connection con;

    public static Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(bbdd,Usuarios,clave);
            System.out.println(con);
            System.out.println("Conexión Exitosa");
        } catch (Exception e) {
            System.out.println("Errosr de conexión a la base de datos " + e.getMessage().toString());
        }
        return con;
    }

    public static void main(String[] args) {
        Conexion.conectar();
    }
}
