package edu.upc.paneando.controllers;

import edu.upc.paneando.dto.ClienteAutenticarDTO;
import edu.upc.paneando.entities.Cliente;
import edu.upc.paneando.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService objClienteService;

   @PostMapping
    public Cliente Autenticar(@RequestBody ClienteAutenticarDTO objCliente){
        return objClienteService.Autenticar(objCliente);
    }
}
