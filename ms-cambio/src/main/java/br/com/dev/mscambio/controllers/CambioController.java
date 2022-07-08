package br.com.dev.mscambio.controllers;

import br.com.dev.mscambio.models.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @Autowired
    private Environment environment;

    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount") BigDecimal amount,@PathVariable("from") String from,@PathVariable("to") String to){
        var port = environment.getProperty("local.server.port");
        return new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, "PORT 8000");
    }

}
