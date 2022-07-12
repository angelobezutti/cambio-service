package br.com.dev.msbook.controllers;

import br.com.dev.msbook.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("book-service")
public class BookController {
    @Autowired
    private Environment environment;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency){
        var port = environment.getProperty("local.server.port");
        return new Book(1L, "Nigel Poulton", new Date(), BigDecimal.valueOf(13.7),"Docker Deep Dive", currency, port);
    }
}
