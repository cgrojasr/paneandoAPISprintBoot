package edu.upc.paneando.entities;

import javax.persistence.*;

@Entity
@Table(name = "producto_precio")
public class ProductoPrecio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto_precio")
    private Long idProductoPrecio;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto objProducto;

    @Column(name = "valor_produccion", nullable = false)
    private Float valorProduccion;

    @Column(name = "valor_venta", nullable = false)
    private Float valorVenta;

    @Column(nullable = false)
    private Boolean activo;
}
