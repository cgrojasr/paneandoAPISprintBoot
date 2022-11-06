package edu.upc.paneando.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_tipo_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_producto_tipo_producto"))
    private TipoProducto objTipoProducto;

    @OneToMany(mappedBy = "objProducto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    Set<PedidoDetalle> lstPedidoDetalle;

    @OneToMany(mappedBy = "objProducto")
    @JsonIgnore
    Set<ProductoPrecio> lstProductoPrecio;

    public Producto() {
    }

    public Producto(Long idProducto, String nombre, String descripcion, Boolean activo, TipoProducto objTipoProducto, Set<PedidoDetalle> lstPedidoDetalle, Set<ProductoPrecio> lstProductoPrecio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
        this.objTipoProducto = objTipoProducto;
        this.lstPedidoDetalle = lstPedidoDetalle;
        this.lstProductoPrecio = lstProductoPrecio;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoProducto getObjTipoProducto() {
        return objTipoProducto;
    }

    public void setObjTipoProducto(TipoProducto objTipoProducto) {
        this.objTipoProducto = objTipoProducto;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Set<PedidoDetalle> getLstPedidoDetalle() {
        return lstPedidoDetalle;
    }

    public void setLstPedidoDetalle(Set<PedidoDetalle> lstPedidoDetalle) {
        this.lstPedidoDetalle = lstPedidoDetalle;
    }

    public Set<ProductoPrecio> getLstProductoPrecio() {
        return lstProductoPrecio;
    }

    public void setLstProductoPrecio(Set<ProductoPrecio> lstProductoPrecio) {
        this.lstProductoPrecio = lstProductoPrecio;
    }
}
