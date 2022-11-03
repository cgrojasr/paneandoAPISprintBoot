package edu.upc.paneando.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PedidoDetalleKey implements Serializable {
    @Column(name = "id_producto")
    private Long idProducto;

    @Column(name = "id_pedido")
    private Long idPedido;

    public PedidoDetalleKey()   {}

    public PedidoDetalleKey(Long idProducto, Long idPedido) {
        this.idProducto = idProducto;
        this.idPedido = idPedido;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
}
