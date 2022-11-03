package edu.upc.paneando.controllers;

import edu.upc.paneando.entities.Producto;
import edu.upc.paneando.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ProductoService objProductoService;

    @GetMapping
    public List<Producto> ListarTodo(){
        return objProductoService.ListarTodo();
    }

    @GetMapping("/{idProducto}")
    public Producto BuscarPorId(@PathVariable Long idProducto){
        return objProductoService.BuscarPorId(idProducto);
    }

    @PostMapping
    public Producto Registrar(@RequestBody Producto objProducto){
        return objProductoService.Registrar(objProducto);
    }

    @DeleteMapping("/{idProducto}")
    public Boolean Eliminar(@PathVariable Long idProducto){
        return objProductoService.Eliminar(idProducto);
    }
}
