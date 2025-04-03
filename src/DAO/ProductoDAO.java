/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.Producto;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Estudiante
 */
public class ProductoDAO {
 public void crearProducto(Producto producto) throws SQLException {
    String sql = """
        INSERT INTO Productos (
            nombre_producto, 
            descripcion_producto, 
            id_categoria, 
            precio_unitario, 
            stock, 
            imagen
        ) VALUES (?, ?, ?, ?, ?, ?)""";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setString(1, producto.getNombreProducto());
        stmt.setString(2, producto.getDescripcionProducto());
        stmt.setInt(3, producto.getIdCategoria());
        stmt.setFloat(4, producto.getPrecioUnitario());
        stmt.setInt(5, producto.getStock());
        stmt.setString(6, producto.getImagen());
        stmt.executeUpdate();
    }
}

public static void main(String[] args) {
    try {
        ProductoDAO dao = new ProductoDAO();
        Producto p1 = new Producto();
        p1.setNombreProducto("Martillo");
        p1.setDescripcionProducto("Martillo de acero");
        p1.setIdCategoria(1);
        p1.setPrecioUnitario(15.99f);
        p1.setStock(50);
        p1.setImagen("ruta/imagen.jpg");
        dao.crearProducto(p1);
        System.out.println("Producto creado con éxito!");
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
}   
}
