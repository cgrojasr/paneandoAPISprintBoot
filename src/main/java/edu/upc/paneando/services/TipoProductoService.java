package edu.upc.paneando.services;

import edu.upc.paneando.entities.TipoProducto;
import edu.upc.paneando.repositories.TipoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoService {
    @Autowired
    private TipoProductoRepository repository;

    public TipoProducto Registrar(TipoProducto objTipoProducto){
        return repository.save(objTipoProducto);
    }

    public List<TipoProducto> ListarTodo(){
        return repository.findAll();
    }

    public Boolean Eliminar(Long idTipoProducto){
        repository.deleteById(idTipoProducto);
        return true;
    }

    public TipoProducto BuscarPorId(Long idTipoProducto){
        return repository.findById(idTipoProducto).orElse(null);
    }
}
