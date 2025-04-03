/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.Date;
import java.util.List;
/**
 *
 * @author JLG
 */
public class Venta {
    private int idVenta;
    private int idCliente; // Relación con Cliente
    private int idEmpleado; // Relación con Empleado
    private Date fechaVenta;
    private float totalVenta;
    private List<DetalleVenta> detalles; // Relación con DetalleVenta

    public Venta(int idVenta, int idCliente, int idEmpleado, Date fechaVenta, float totalVenta, List<DetalleVenta> detalles) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.fechaVenta = fechaVenta;
        this.totalVenta = totalVenta;
        this.detalles = detalles;
    }

    public Venta() {
    }
    
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public float getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(float totalVenta) {
        this.totalVenta = totalVenta;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }
    
     
}
