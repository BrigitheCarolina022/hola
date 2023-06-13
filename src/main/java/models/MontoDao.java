package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.UnsupportedAudioFileException;

import controller.Monto;

public class MontoDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = null;
    int r;

    public int registrar(MontoVo Monto) throws SQLException {
        sql = "INSERT INTO Monto(Monto) values(?)";

        try {
            con = Conexion.conectar(); // abrir conexión
            ps = con.prepareStatement(sql); // preparar sentencia
            ps.setInt(1, Monto.getMonto());
            System.out.println(ps);
            ps.executeUpdate(); // Ejecutar sentencia
            ps.close(); // cerrar sentencia
            System.out.println("Se registró el bolsillo digital correctamente");
        } catch (Exception e) {
            System.out.println("Error en el regisro " + e.getMessage().toString());
        } finally {
            con.close();// cerrando conexión
        }
        return r;
    }

    public int modificar(MontoVo Monto) throws SQLException {
        sql = "UPDATE  Monto SET Monto=? WHERE Id_Monto=?";

        try {
            con = Conexion.conectar(); // abrir conexión
            ps = con.prepareStatement(sql); // preparar sentencia
            ps.setInt(1, Monto.getMonto());
            System.out.println(ps);
            ps.executeUpdate(); // Ejecutar sentencia
            ps.close(); // cerrar sentencia
            System.out.println("Se registró el bolsillo digital correctamente");
        } catch (Exception e) {
            System.out.println("Error en el regisro " + e.getMessage().toString());
        } finally {
            con.close();// cerrando conexión
        }
        return r;
    }

    

    public List<MontoVo> listar() throws SQLException {
            List<MontoVo> Monto = new ArrayList<>();
            sql = "select * from Monto";
            System.out.println(sql);
            try {
                con = Conexion.conectar();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery(sql);
                System.out.println(ps);
                while (rs.next()) {
                    MontoVo r = new MontoVo();
                    r.setId_Monto(rs.getInt("Id_Monto"));
                    r.setMonto(rs.getInt("Monto"));
                    Monto.add(r);
                    System.out.println(ps);
                }
                ps.close();
                System.out.println("consulta exitosa");
            } catch (Exception e) {
                System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());
            } finally {
                con.close();
            }
            
            return Monto;
        }

}
