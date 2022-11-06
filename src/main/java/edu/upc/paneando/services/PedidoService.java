package edu.upc.paneando.services;

import edu.upc.paneando.entities.*;
import edu.upc.paneando.repositories.PedidoDetalleRepository;
import edu.upc.paneando.repositories.PedidoRepository;
import edu.upc.paneando.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository objPedidoRepository;
    @Autowired
    private PedidoDetalleRepository objPedidoDetalleRepository;
    @Autowired
    private ProductoRepository objProductoRepository;

    public List<Pedido> ListarTodo(){
        return objPedidoRepository.findAll();
    }

    public Pedido BuscarPorId(Long idPedido){
        return objPedidoRepository.findById(idPedido).orElse(null);
    }

    public Boolean Eliminar(Long idPedido){
        objPedidoRepository.deleteById(idPedido);
        return true;
    }

    public Pedido Registrar(Pedido objPedido){
        try{
            for(PedidoDetalle objPedidoDetalle : objPedido.getLstPedidoDetalle()){
                Producto objProducto = new Producto();
                objProducto = objProductoRepository.findById(objPedidoDetalle.getIdPedidoDetalle().getIdProducto()).orElse(null);
                objPedidoDetalle.setObjPedido(objPedido);
                objPedidoDetalle.setObjProducto(objProducto);
            }

            for(PedidoFecha objPedidoFecha : objPedido.getLstPedidoFecha()){
                objPedidoFecha.setObjPedido(objPedido);
            }

            return objPedidoRepository.save(objPedido);
        } catch (Exception e){
            throw e;
        }
    }
}
