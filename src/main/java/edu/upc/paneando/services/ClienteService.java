package edu.upc.paneando.services;

import edu.upc.paneando.dto.ClienteAutenticarDTO;
import edu.upc.paneando.entities.Cliente;
import edu.upc.paneando.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository objClienteRepository;

    public Cliente Autenticar(ClienteAutenticarDTO objCliente){
        return objClienteRepository.findByEmailAndPassword(objCliente.email, objCliente.password);
    }
}
