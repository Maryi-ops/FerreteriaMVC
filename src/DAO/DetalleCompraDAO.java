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

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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

   public List<DetalleCompra> leerTodosDetallesCompra() throws SQLException {
        String sql = "SELECT * FROM Detalles_Compras";
        List<DetalleCompra> detalles = new ArrayList<>();

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DetalleCompra detalle = new DetalleCompra();
                detalle.setIdDetalleCompra(rs.getInt("id_detalle_compra"));
                detalle.setIdCompra(rs.getInt("id_compra"));
                detalle.setIdProducto(rs.getInt("id_producto"));
                detalle.setCantidad(rs.getInt("cantidad"));
                detalle.setPrecioUnitario(rs.getFloat("precio_unitario"));
                detalles.add(detalle);
            }
        }
        return detalles;
    }
public static void main(String[] args) {
    try {
        DetalleCompraDAO dao = new DetalleCompraDAO();
         List<DetalleCompra> detalles = dao.leerTodosDetallesCompra();
            System.out.println("Lista de detalles de compra:");
            for (DetalleCompra det : detalles) {
                System.out.println("ID: " + det.getIdDetalleCompra() + 
                                 ", Compra ID: " + det.getIdCompra() + 
                                 ", Producto ID: " + det.getIdProducto() + 
                                 ", Cantidad: " + det.getCantidad() + 
                                 ", Precio Unitario: " + det.getPrecioUnitario());
            }
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
}  
}
