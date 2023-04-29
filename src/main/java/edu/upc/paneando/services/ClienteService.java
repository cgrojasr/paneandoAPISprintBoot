package edu.upc.paneando.services;

import edu.upc.paneando.dto.ClienteAutenticarDTO;
import edu.upc.paneando.dto.ClienteLoginDTO;
import edu.upc.paneando.entities.Cliente;
import edu.upc.paneando.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository objClienteRepository;

    public ClienteLoginDTO Autenticar(ClienteAutenticarDTO objCliente){
        Cliente objClienteEntity = new Cliente();
        objClienteEntity = objClienteRepository.findByEmailAndPassword(objCliente.email, objCliente.password);
        ClienteLoginDTO objClienteLogin = new ClienteLoginDTO(
                objClienteEntity.idCliente,
                objClienteEntity.nombres,
                objClienteEntity.apellidos,
                objClienteEntity.activo
        );
        return  objClienteLogin;
    }
}
