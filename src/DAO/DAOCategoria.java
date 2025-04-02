/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.Categoria;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Estudiante
 */
public class DAOCategoria {
  public void crearCategoria(Categoria categoria) throws SQLException{
      String sql = "INSERT INTO Categoria (nombre_categoria, descripcion_categoria) VALUES (?,?)";
      try (Connection c = ConexionDB.getConnection();
           PreparedStatement stmt = c.prepareStatement(sql)) {
          stmt.setString(1, categoria.getNombreCategaoria());
          stmt.setString(2, categoria.getDescripcionCategaoria());
          stmt.executeUpdate();
      }
  }
 public static void main(String[ ] args) {
    try {
        DAOCategoria dao = new DAOCategoria();
        Categoria c1 = new Categoria();
        c1.setNombreCategaoria("Herramientas");
        c1.setDescripcionCategaoria("Categoría para herramientas de ferretería");
        dao.crearCategoria(c1);
        System.out.println("Categoria creada con éxito!");
    } catch (SQLException e) {
        System.err.println("Error al crear categoria: " + e.getMessage());
    }
 }
 
}
