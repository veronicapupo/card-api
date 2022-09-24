package com.amefastforward.cardapi.controller;

import com.amefastforward.cardapi.controller.request.CreateCardRequest;
import com.amefastforward.cardapi.controller.request.UpdateCardRequest;
import com.amefastforward.cardapi.model.Card;
import com.amefastforward.cardapi.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/card")
public class CardController {

    private static final Logger LOG = LoggerFactory.getLogger(CardController.class);

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/health")
    public String health() {
        LOG.info("Verificando API");
        return "OK";
    }

    @GetMapping("{id}")
    public Card findCardById(@PathVariable("id") int id) {
        LOG.info("Iniciando busca pelo card com id [{}]", id);
        return cardService.findById(id);

    }

    @PostMapping
    public Card createCard(@RequestBody CreateCardRequest createCardRequest) throws Exception {
        LOG.info("Iniciando criacao de Card com nome [{}]", createCardRequest.getName());
        return cardService.createCard(createCardRequest);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("{id}")
    public void deleteCard(@PathVariable("id") long id) {
        LOG.info("Deletando card com id [{}]", id);
        cardService.deleteCard(id);
    }

    @PutMapping("{id}")
    public Card updateCard(@PathVariable("id") long id, @RequestBody UpdateCardRequest updateCardRequest) {
        LOG.info("Atualizando card com id [{}]", id);
        return cardService.update(id, updateCardRequest);
    }
}