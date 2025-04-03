/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.Usuario;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Estudiante
 */
public class UsuarioDAO {
 public void crearUsuario(Usuario usuario) throws SQLException {
    String sql = """
        INSERT INTO Usuarios (
            usuario, 
            contraseña
        ) VALUES (?, ?)""";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setString(1, usuario.getUsuario());
        stmt.setString(2, usuario.getContrasena());
        stmt.executeUpdate();
    }
}

public static void main(String[] args) {
    try {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u1 = new Usuario();
        u1.setUsuario("admin");
        u1.setContrasena("12345");
        dao.crearUsuario(u1);
        System.out.println("Usuario creado con éxito!");
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
}
   
}
