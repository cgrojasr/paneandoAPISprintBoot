package edu.upc.paneando.services;

import edu.upc.paneando.entities.Producto;
import edu.upc.paneando.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
