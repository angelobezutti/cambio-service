package br.com.dev.mscambio.controllers;

import br.com.dev.mscambio.models.Cambio;
import br.com.dev.mscambio.repositories.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Tag(name = "Cambio Service API")
@RestController
@RequestMapping("cambio-service")
public class CambioController {

    @Autowired
    private Environment environment;
    @Autowired
    private CambioRepository repository;

    @Operation(description = "Get cambio from currenc!")
    @GetMapping(value = "/{amount}/{from}/{to}")
    public Cambio getCambio(@PathVariable("amount") BigDecimal amount,@PathVariable("from") String from,@PathVariable("to") String to){
        var cambio = repository.findByFromAndTo(from, to);
        if (cambio == null) throw  new RuntimeException("Currency Unsuported");

        var port = environment.getProperty("local.server.port");
        BigDecimal convesionFactor = cambio.getConversionFactor();
        BigDecimal convertedValue = convesionFactor.multiply(amount);
        cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));
        cambio.setEnvironment(port);
        return cambio;
    }

}
