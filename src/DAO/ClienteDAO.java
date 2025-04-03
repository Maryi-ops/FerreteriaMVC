/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Modelo.Cliente;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    public void crearCliente(Cliente cliente) throws SQLException {
    String sql = """
        INSERT INTO Clientes (
            primer_nombre, 
            segundo_nombre, 
            primer_apellido, 
            segundo_apellido, 
            celular, 
            direccion, 
            cedula
        ) VALUES (?, ?, ?, ?, ?, ?, ?)""";
    
    try (Connection c = ConexionDB.getConnection();
         PreparedStatement stmt = c.prepareStatement(sql)) {
        stmt.setString(1, cliente.getPrimerNombre());
        stmt.setString(2, cliente.getSegundoNombre());
        stmt.setString(3, cliente.getPrimerApellido());
        stmt.setString(4, cliente.getSegundoApellido());
        stmt.setString(5, cliente.getCelular());
        stmt.setString(6, cliente.getDireccion());
        stmt.setString(7, cliente.getCedula());
        stmt.executeUpdate();
    }
}

public static void main(String[] args) {
    try {
        ClienteDAO dao = new ClienteDAO();
        Cliente c1 = new Cliente();
        c1.setPrimerNombre("Juan");
        c1.setSegundoNombre("Carlos");
        c1.setPrimerApellido("Pérez");
        c1.setSegundoApellido("Gómez");
        c1.setCelular("12345678");
        c1.setDireccion("Calle 123, Ciudad");
        c1.setCedula("12345678901234");
        dao.crearCliente(c1);
        System.out.println("Cliente creado con éxito!");
    } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
    }
}
}
