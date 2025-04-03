/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.Venta;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author Estudiante
 */
public class VentaDAO {
   public void crearVenta(Venta venta) throws SQLException {
    String sql = """
        INSERT INTO Ventas (
            id_cliente, 
            id_empleado, 
            fecha_venta, 
            total_venta
        ) VALUES (?, ?, ?, ?)""";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setInt(1, venta.getIdCliente());
        stmt.setInt(2, venta.getIdEmpleado());
        stmt.setTimestamp(3, new java.sql.Timestamp(venta.getFechaVenta().getTime()));
        stmt.setFloat(4, venta.getTotalVenta());
        stmt.executeUpdate();
    }
}

public static void main(String[] args) {
    try {
        VentaDAO dao = new VentaDAO();
        Venta v1 = new Venta();
        v1.setIdCliente(1);
        v1.setIdEmpleado(1);
        v1.setFechaVenta(new Date());
        v1.setTotalVenta(200.75f);
        dao.crearVenta(v1);
        System.out.println("Venta creada con éxito!");
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
} 
}
