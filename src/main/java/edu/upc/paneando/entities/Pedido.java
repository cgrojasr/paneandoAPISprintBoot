package edu.upc.paneando.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idPedido;

    @Column(nullable = false)
    public Date fecha;

    @Column(nullable = false)
    public String direccion;

    @Column(name = "fecha_inicio", nullable = false)
    public Date fechaInicio;

    @Column(name = "fecha_fin", nullable = false)
    public Date fechaFin;

    @Column(nullable = false)
    public String email;

    @Column(nullable = false)
    public Integer estado;

    @OneToMany(mappedBy = "objPedido", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<PedidoDetalle> lstPedidoDetalle = new HashSet<PedidoDetalle>();

    @OneToMany(mappedBy = "objPedido", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<PedidoFecha> lstPedidoFecha = new HashSet<PedidoFecha>();


    public Pedido() {
    }

    public Pedido(Long idPedido, Date fecha, String direccion, Date fechaInicio, Date fechaFin, String email, Integer estado, Set<PedidoDetalle> lstPedidoDetalle, Set<PedidoFecha> lstPedidoFecha) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.direccion = direccion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.email = email;
        this.estado = estado;
        this.lstPedidoDetalle = lstPedidoDetalle;
        this.lstPedidoFecha = lstPedidoFecha;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Set<PedidoDetalle> getLstPedidoDetalle() {
        return lstPedidoDetalle;
    }

    public void setLstPedidoDetalle(Set<PedidoDetalle> lstPedidoDetalle) {
        this.lstPedidoDetalle = lstPedidoDetalle;
    }

    public Set<PedidoFecha> getLstPedidoFecha() {
        return lstPedidoFecha;
    }

    public void setLstPedidoFecha(Set<PedidoFecha> lstPedidoFecha) {
        this.lstPedidoFecha = lstPedidoFecha;
    }
}
