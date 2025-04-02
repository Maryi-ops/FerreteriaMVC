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
public class Compra {

    
    private int idCompra;
    private Empleado empleado; // Relación con Empleado
    private Date fechaCompra;
    private float totalCompra;
    private List<DetalleCompra> detalles; // Relación con DetalleCompra
    
     public Compra(int idCompra, Empleado empleado, Date fechaCompra, float totalCompra, List<DetalleCompra> detalles) {
        this.idCompra = idCompra;
        this.empleado = empleado;
        this.fechaCompra = fechaCompra;
        this.totalCompra = totalCompra;
        this.detalles = detalles;
    }
     
     public Compra() {
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public float getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(float totalCompra) {
        this.totalCompra = totalCompra;
    }

    public List<DetalleCompra> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCompra> detalles) {
        this.detalles = detalles;
    }

   
}
