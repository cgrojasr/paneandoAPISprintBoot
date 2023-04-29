package edu.upc.paneando.controllers;

import edu.upc.paneando.dto.ClienteAutenticarDTO;
import edu.upc.paneando.dto.ClienteLoginDTO;
import edu.upc.paneando.entities.Cliente;
import edu.upc.paneando.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService objClienteService;

   @PostMapping
    public ClienteLoginDTO Autenticar(@RequestBody ClienteAutenticarDTO objCliente){
        return objClienteService.Autenticar(objCliente);
    }
}
