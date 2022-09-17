package com.amefastforward.cardapi.controller;

import com.amefastforward.cardapi.model.Card;
import com.amefastforward.cardapi.service.CardService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.logging.Logger;

@RestController
@RequestMapping("/card")

public class CardController {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(CardController.class);

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/health")
    public String health(){
        LOG.info("Verificando API");
        return"OK";
    }


    @GetMapping("{id}")
    public Card findCardById(@PathVariable("id") int id) {

        LOG.info ("Iniciando busca pelo card com id [{}]", id);
        var card = cardService.findById(id);

        if (card.isPresent()) {
    return  card.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card não encontrado");
    }

}
