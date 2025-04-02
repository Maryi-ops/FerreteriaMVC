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
    private Cliente cliente; // Relación con Cliente
    private Empleado empleado; // Relación con Empleado
    private Date fechaVenta;
    private float totalVenta;
    private List<DetalleVenta> detalles; // Relación con DetalleVenta
    
      public Venta(int idVenta, Cliente cliente, Empleado empleado, Date fechaVenta, float totalVenta, List<DetalleVenta> detalles) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.empleado = empleado;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
