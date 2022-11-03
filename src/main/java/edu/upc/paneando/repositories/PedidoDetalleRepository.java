package edu.upc.paneando.repositories;

import edu.upc.paneando.entities.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle, Serializable> {
}
