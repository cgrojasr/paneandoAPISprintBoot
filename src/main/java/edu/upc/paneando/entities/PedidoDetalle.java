package edu.upc.paneando.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "pedido_detalle")
public class PedidoDetalle {
    @EmbeddedId
    private PedidoDetalleKey idPedidoDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPedido")
    @JoinColumn(name = "id_pedido")
    @JsonIgnore
    private Pedido objPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    @JsonIgnore
    private Producto objProducto;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "valor_venta", nullable = false)
    private Float valorVenta;

    @Column(nullable = false)
    private Boolean eliminado;

    public PedidoDetalle(){}

    public PedidoDetalle(PedidoDetalleKey idPedidoDetalle, Pedido objPedido, Producto objProducto, Integer cantidad, Float valorVenta, Boolean eliminado) {
        this.idPedidoDetalle = idPedidoDetalle;
        this.objPedido = objPedido;
        this.objProducto = objProducto;
        this.cantidad = cantidad;
        this.valorVenta = valorVenta;
        this.eliminado = eliminado;
    }

    public PedidoDetalleKey getIdPedidoDetalle() {
        return idPedidoDetalle;
    }

    public void setIdPedidoDetalle(PedidoDetalleKey idPedidoDetalle) {
        this.idPedidoDetalle = idPedidoDetalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Float valorVenta) {
        this.valorVenta = valorVenta;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Pedido getObjPedido() {
        return objPedido;
    }

    public void setObjPedido(Pedido objPedido) {
        this.objPedido = objPedido;
    }

    public Producto getObjProducto() {
        return objProducto;
    }

    public void setObjProducto(Producto objProducto) {
        this.objProducto = objProducto;
    }
}
