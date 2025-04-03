/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.DetalleCompra;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Estudiante
 */
public class DetalleCompraDAO {
  public void crearDetalleCompra(DetalleCompra detalle) throws SQLException {
    String sql = """
        INSERT INTO Detalles_Compras (
            id_compra, 
            id_producto, 
            cantidad, 
            precio_unitario
        ) VALUES (?, ?, ?, ?)""";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setInt(1, detalle.getIdCompra());
        stmt.setInt(2, detalle.getIdProducto());
        stmt.setInt(3, detalle.getCantidad());
        stmt.setFloat(4, detalle.getPrecioUnitario());
        stmt.executeUpdate();
    }
}

public static void main(String[] args) {
    try {
        DetalleCompraDAO dao = new DetalleCompraDAO();
        DetalleCompra d1 = new DetalleCompra();
        d1.setIdCompra(1);
        d1.setIdProducto(1);
        d1.setCantidad(5);
        d1.setPrecioUnitario(25.75f);
        dao.crearDetalleCompra(d1);
        System.out.println("Detalle de compra creado con éxito!");
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
}  
}
