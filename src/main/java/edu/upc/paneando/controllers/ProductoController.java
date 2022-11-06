package edu.upc.paneando.controllers;

import edu.upc.paneando.entities.Producto;
import edu.upc.paneando.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/filtro")
    public ResponseEntity<List<Producto>> BuscarPorNombre(@RequestParam(value = "nombre", required = false) String nombre,
                                                          @RequestParam(value = "descripcion", required = false) String descripcion,
                                                          @RequestParam(value = "idTipoProducto", required = false) Long idTipoProducto){
        try{
            if(descripcion == null && nombre != null)
                return new ResponseEntity<>(objProductoService.BuscarPorNombre(nombre), HttpStatus.OK);

            if(nombre == null && descripcion !=null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            if(descripcion == null && nombre == null && idTipoProducto != null){
                if(idTipoProducto == 0)
                    return new ResponseEntity<>(objProductoService.ListarTodo(), HttpStatus.OK);
                else
                    return new ResponseEntity<>(objProductoService.BuscarPorTipoProducto(idTipoProducto), HttpStatus.OK);
            }

            return new ResponseEntity<>(objProductoService.BuscarPorNombreODescripcion(nombre, descripcion), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
