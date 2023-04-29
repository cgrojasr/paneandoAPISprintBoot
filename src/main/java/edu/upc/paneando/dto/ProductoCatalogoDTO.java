package edu.upc.paneando.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoCatalogoDTO {
    @JsonProperty("id_producto")
    private Long idProducto;
    private String nombre;
    private String descripcion;
    @JsonProperty("image_URL")
    private String imageURL;
    @JsonProperty("valor_venta")
    private Float valorVenta;
    @JsonProperty("tipo_producto")
    private String tipoProducto;
}
