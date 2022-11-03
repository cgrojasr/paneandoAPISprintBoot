package edu.upc.paneando.services;

import edu.upc.paneando.entities.Pedido;
import edu.upc.paneando.entities.PedidoDetalle;
import edu.upc.paneando.entities.PedidoDetalleKey;
import edu.upc.paneando.entities.Producto;
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
//           Pedido objPedidoRegistrado =  new Pedido();
//           objPedidoRegistrado.setDireccion(objPedido.getDireccion());
//           objPedidoRegistrado.setEmail(objPedido.getEmail());
//           objPedidoRegistrado.setFecha(objPedido.getFecha());
//           objPedidoRegistrado.setFechaInicio(objPedido.getFechaInicio());
//           objPedidoRegistrado.setFechaFin(objPedido.getFechaFin());
//           objPedidoRegistrado.setLstPedidoDetalle(objPedido.getLstPedidoDetalle()
//                   .stream()
//                   .map(pedido ->{
//                       Producto objProducto = objProductoRepository.findById(pedido.getIdPedidoDetalle().getIdProducto());
//                       PedidoDetalle objPedidoDetalleRegistrado = new PedidoDetalle();
//                       objPedidoDetalleRegistrado.
//                   }));
////            for(PedidoDetalle objPedidoDetalle: objPedido.getLstPedidoDetalle()){
////                PedidoDetalleKey idPedidoDetalle = objPedidoDetalle.getIdPedidoDetalle();
////                idPedidoDetalle.setIdPedido(objPedidoRegistrado.idPedido);
////                objPedidoDetalleRepository.save(objPedidoDetalle);
////            }
////            return objPedidoRepository.findById(objPedidoRegistrado.getIdPedido()).orElse(null);
            for(PedidoDetalle objPedidoDetalle : objPedido.getLstPedidoDetalle()){
                Producto objProducto = new Producto();
                objProducto = objProductoRepository.findById(objPedidoDetalle.getIdPedidoDetalle().getIdProducto()).orElse(null);
                objPedidoDetalle.setObjPedido(objPedido);
                objPedidoDetalle.setObjProducto(objProducto);
            }
            return objPedidoRepository.save(objPedido);
            //return null;
        } catch (Exception e){
            throw e;
        }
    }
}
