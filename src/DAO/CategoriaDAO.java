
package DAO;
import Modelo.Categoria;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Estudiante
 */
public class CategoriaDAO {
 public void crearCategoria(Categoria categoria) throws SQLException {
    String sql = """
        INSERT INTO Categorias (
            nombre_categoria, 
            descripcion_categoria
        ) VALUES (?, ?) """;

    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setString(1, categoria.getNombreCategaoria());
        stmt.setString(2, categoria.getDescripcionCategaoria());
        stmt.executeUpdate();
    }
}

    // Método para leer todas las categorías
   public List<Categoria> leerTodasCategorias() throws SQLException {
    String sql = "SELECT * FROM Categorias";
    List<Categoria> categorias = new ArrayList<>();
   try (Connection c = ConexionDB.getConnection();
   PreparedStatement stmt = c.prepareStatement(sql);
   ResultSet rs = stmt.executeQuery()) {
   while (rs.next()) {
   Categoria categoria = new Categoria();
   categoria.setIdCategoria(rs.getInt("id_categoria"));
   categoria.setNombreCategaoria(rs.getString("nombre_categoria"));
   categoria.setDescripcionCategaoria(rs.getString("descripcion_categoria"));
   categorias.add(categoria);
   }
   }
   return categorias;
   }
public static void main(String[] args) {
    try {
        CategoriaDAO dao = new CategoriaDAO();
       // Leer y mostrar todas las categorías
            List<Categoria> categorias = dao.leerTodasCategorias();
            System.out.println("\nLista de categorías:");
            for (Categoria cat : categorias) {
                System.out.println("ID: " + cat.getIdCategoria() + 
                                    ", Nombre: " + cat.getNombreCategaoria() + 
                                    ", Descripción: " + cat.getDescripcionCategaoria());
            }
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
}
 
}
