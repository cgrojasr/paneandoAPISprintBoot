package edu.upc.paneando.services;

import edu.upc.paneando.dto.ProductoCatalogoDTO;
import edu.upc.paneando.entities.Producto;
import edu.upc.paneando.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    public Producto BuscarPorId(Long idProducto){
        return repository.findById(idProducto).orElse(null);
    }

    public List<Producto> ListarTodo(){
        return repository.findAll();
    }

    public Producto Registrar(Producto objProducto){
        return repository.save(objProducto);
    }

    public Boolean Eliminar(Long idProducto){
        repository.deleteById(idProducto);
        return true;
    }

    public List<Producto> BuscarPorNombre(String nombre){
        return repository.findByNombreContaining(nombre);
    }

    public List<Producto> BuscarPorNombreODescripcion(String nombre, String descripcion){
        return repository.findByNombreOrDescripcionContaining(nombre, descripcion);
    }

    public List<Producto> BuscarPorTipoProducto(Long idTipoProducto){
        return repository.findByIdTipoProducto(idTipoProducto);
    }

    public List<ProductoCatalogoDTO> ListarCatalogo(){
        try{
            return repository.ListarCatalogo();
        } catch (Exception ex){
            throw ex;
        }
    }
}
