package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.UnsupportedAudioFileException;

import controller.TipoBolsillo;

public class TipoBolsilloDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = null;
    int r;

    public int registrar(TipoBolsilloVo TipoBolsillo) throws SQLException {
        sql = "INSERT INTO tipo_bolsillo(Nequi,Daviplata) values(?,?)";

        try {
            con = Conexion.conectar(); // abrir conexión
            ps = con.prepareStatement(sql); // preparar sentencia
            ps.setString(1, TipoBolsillo.getNequi());
            ps.setString(2, TipoBolsillo.getDaviplata());
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

    public int modificar (TipoBolsilloVo TipoBolsillo) throws SQLException {
        sql = "UPDATE tipo_bolsillo SET Nequi= ?, Daviplata=? WHERE Id_TipoBolsillo=?";

        try {
            con = Conexion.conectar(); // abrir conexión
            ps = con.prepareStatement(sql); // preparar sentencia
            ps.setString(1, TipoBolsillo.getNequi());
            ps.setString(2, TipoBolsillo.getDaviplata());
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

    public List<TipoBolsilloVo> listar() throws SQLException {
        List<TipoBolsilloVo> TipoBolsillo = new ArrayList<>();
        sql = "select * from tipo_bolsillo";
        System.out.println(sql);
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            System.out.println(ps);
            while (rs.next()) {
                TipoBolsilloVo r = new TipoBolsilloVo();

                r.setId_TipoBolsillo(rs.getInt("Id_TipoBolsillo"));
                r.setNequi(rs.getString("Nequi"));
                r.setDaviplata(rs.getString("Daviplata"));
                TipoBolsillo.add(r);
                System.out.println(ps);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());
        } finally {
            con.close();
        }

        return TipoBolsillo;
    }

}
