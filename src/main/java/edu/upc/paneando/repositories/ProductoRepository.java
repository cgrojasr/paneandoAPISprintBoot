package edu.upc.paneando.repositories;

import edu.upc.paneando.dto.ProductoCatalogoDTO;
import edu.upc.paneando.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombreContaining(String nombre);
    List<Producto> findByNombreOrDescripcionContaining(String nombre, String descripcion);
    @Query("SELECT p FROM Producto p WHERE p.objTipoProducto.idTipoProducto = :idTipoProducto")
    List<Producto> findByIdTipoProducto(Long idTipoProducto);

    @Query(name = "listar_catalogo", nativeQuery = true)
    List<ProductoCatalogoDTO> ListarCatalogo();
}
