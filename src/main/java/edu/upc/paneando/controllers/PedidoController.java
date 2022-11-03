package edu.upc.paneando.controllers;

import edu.upc.paneando.entities.Pedido;
import edu.upc.paneando.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService objPedidoService;

    @GetMapping
    public List<Pedido> ListarTodo(){
        return objPedidoService.ListarTodo();
    }

    @GetMapping("/{idPedido}")
    public Pedido BuscarPorId(@PathVariable Long idPedido){
        return objPedidoService.BuscarPorId(idPedido);
    }

    @PostMapping
    public Pedido Registrar(@RequestBody Pedido objPedido){
        return objPedidoService.Registrar(objPedido);
    }

    @DeleteMapping
    public Boolean Eliminar(@PathVariable Long idPedido){
        return objPedidoService.Eliminar(idPedido);
    }
}
