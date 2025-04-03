/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.DetalleVenta;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Estudiante
 */
public class DetalleVentaDAO {
    public void crearDetalleVenta(DetalleVenta detalle) throws SQLException {
    String sql = """
        INSERT INTO Detalles_Ventas (
            id_venta, 
            id_producto, 
            cantidad, 
            precio_unitario
        ) VALUES (?, ?, ?, ?)""";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setInt(1, detalle.getIdVenta());
        stmt.setInt(2, detalle.getIdProducto());
        stmt.setInt(3, detalle.getCantidad());
        stmt.setFloat(4, detalle.getPrecioUnitario());
        stmt.executeUpdate();
    }
}

public static void main(String[] args) {
    try {
        DetalleVentaDAO dao = new DetalleVentaDAO();
        DetalleVenta d1 = new DetalleVenta();
        d1.setIdVenta(1);
        d1.setIdProducto(1);
        d1.setCantidad(3);
        d1.setPrecioUnitario(30.00f);
        dao.crearDetalleVenta(d1);
        System.out.println("Detalle de venta creado con éxito!");
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
}
       

}
