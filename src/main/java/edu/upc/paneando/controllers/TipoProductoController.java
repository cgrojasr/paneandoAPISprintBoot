package edu.upc.paneando.controllers;

import edu.upc.paneando.entities.TipoProducto;
import edu.upc.paneando.services.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoproducto")
public class TipoProductoController {
    @Autowired
    private TipoProductoService objTipoProductoService;

    @PostMapping
    public TipoProducto Registrar(@RequestBody TipoProducto objTipoProducto){
        return objTipoProductoService.Registrar(objTipoProducto);
    }

    @GetMapping
    public List<TipoProducto> ListarTodo(){
        return objTipoProductoService.ListarTodo();
    }

    @DeleteMapping("/{idTipoProducto}")
    public Boolean Eliminar(@PathVariable Long idTipoProducto){
        return objTipoProductoService.Eliminar(idTipoProducto);
    }

    @GetMapping("/buscarporid/{idTipoProducto}")
    public TipoProducto BuscarPorId(@PathVariable Long idTipoProducto){
        return objTipoProductoService.BuscarPorId(idTipoProducto);
    }
}
