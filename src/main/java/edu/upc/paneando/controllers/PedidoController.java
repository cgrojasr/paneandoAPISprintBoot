package edu.upc.paneando.controllers;

import edu.upc.paneando.entities.Pedido;
import edu.upc.paneando.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService objPedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> ListarTodo(){
        try{
            return new ResponseEntity<>(objPedidoService.ListarTodo(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<Pedido> BuscarPorId(@PathVariable Long idPedido){
        try{
            Pedido objPedido = objPedidoService.BuscarPorId(idPedido);
            if(objPedido==null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(objPedido, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping
    public ResponseEntity<Pedido>  Registrar(@RequestBody Pedido objPedido){
        try{
            Pedido objPedidoRegistrado = objPedidoService.Registrar(objPedido);
            if(objPedidoRegistrado.getIdPedido() == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(objPedidoRegistrado, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }

    @DeleteMapping
    public Boolean Eliminar(@PathVariable Long idPedido){
        return objPedidoService.Eliminar(idPedido);
    }
}
