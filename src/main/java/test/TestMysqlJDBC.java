package test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;




public class TestMysqlJDBC {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true"; // url cadena de conexion a base de datos
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url,"root", "admin");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("id Persona: " + resultado.getInt("id_persona"));
                System.out.print("nombre: " + resultado.getString("nombre"));
                System.out.print("Apellido: " + resultado.getString("apellido"));
                System.out.print("Email:" + resultado.getString("email"));
                System.out.print("Email:" + resultado.getString("email actualizado en repositorio"));
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
