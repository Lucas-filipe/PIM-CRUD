package br.com.pim.helplog.controllers;

import br.com.pim.helplog.model.Cliente;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin //Permite chamar de qualquer lugar
public class LoginController {



    @GetMapping(value = "/teste", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String teste(){
        return ("teste");
    }

    @PostMapping(value = "/testPost", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String testPost(@RequestBody Cliente cliente){
        return cliente.getNome();
    }
}
