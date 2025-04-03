/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.Compra;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author Estudiante
 */
public class CompraDAO {
   public void crearCompra(Compra compra) throws SQLException {
    String sql = """
        INSERT INTO Compras (
            id_empleado, 
            fecha_compra, 
            total_compra
        ) VALUES (?, ?, ?)""";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setInt(1, compra.getIdEmpleado());
        stmt.setDate(2, new java.sql.Date(compra.getFechaCompra().getTime()));
        stmt.setFloat(3, compra.getTotalCompra());
        stmt.executeUpdate();
    }
}

public static void main(String[] args) {
    try {
        CompraDAO dao = new CompraDAO();
        Compra c1 = new Compra();
        c1.setIdEmpleado(1);
        c1.setFechaCompra(new Date());
        c1.setTotalCompra(150.50f);
        dao.crearCompra(c1);
        System.out.println("Compra creada con éxito!");
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
} 
}
