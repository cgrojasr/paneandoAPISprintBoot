package edu.upc.paneando.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.upc.paneando.dto.ProductoCatalogoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedNativeQuery(
        name = "listar_catalogo",
        query =
                "SELECT " +
                        "PRO.id_producto AS idProducto, " +
                        "PRO.nombre AS nombre, " +
                        "PRO.descripcion AS descripcion, " +
                        "PRO.image_URL AS imageURL , " +
                        "PRE.valor_venta AS valorVenta, " +
                        "TIP.nombre AS tipoProducto " +
                        "FROM producto PRO " +
                        "INNER JOIN producto_precio PRE ON  PRO.id_producto = PRE.id_producto AND PRE.activo = true " +
                        "INNER JOIN tipo_producto TIP ON  PRO.id_tipo_producto = TIP.id_tipo_producto " +
                        "WHERE PRO.id_tipo_producto = 1 AND PRO.activo = true " +
                        //"  AND product_code IN :productCodes " +
                        "ORDER BY PRO.nombre",
        resultSetMapping = "producto_catalogo_dto"
)
@SqlResultSetMapping(
        name = "producto_catalogo_dto",
        classes = @ConstructorResult(
                targetClass = ProductoCatalogoDTO.class,
                columns = {
                        @ColumnResult(name = "idProducto", type = Long.class),
                        @ColumnResult(name = "nombre", type = String.class),
                        @ColumnResult(name = "descripcion", type = String.class),
                        @ColumnResult(name = "imageURL", type = String.class),
                        @ColumnResult(name = "valorVenta", type = Float.class),
                        @ColumnResult(name = "tipoProducto", type = String.class)
                }
        )
)
@Table(name = "producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "image_URL")
    private String imageURL;

    @Column(name = "activo", nullable = false)
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_tipo_producto", foreignKey = @ForeignKey(name = "FK_producto_tipo_producto"))
    private TipoProducto objTipoProducto;

    @OneToMany(mappedBy = "objProducto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    Set<PedidoDetalle> lstPedidoDetalle;

    @OneToMany(mappedBy = "objProducto")
    @JsonIgnore
    Set<ProductoPrecio> lstProductoPrecio;
}
