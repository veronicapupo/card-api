package com.amefastforward.cardapi.controller;


import com.amefastforward.cardapi.controller.request.CreateCardOriginRequest;
import com.amefastforward.cardapi.controller.request.UpdateCardOriginRequest;
import com.amefastforward.cardapi.model.CardOrigin;
import com.amefastforward.cardapi.service.CardOriginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card-origin")
public class CardOriginController {

    private static final Logger LOG = LoggerFactory.getLogger(CardOriginController.class);

    @Autowired
    private CardOriginService cardOriginService;

    @GetMapping("{id}")
    public CardOrigin findCardOriginById(@PathVariable("id") int id) {
        LOG.info("Buscando card com id {}", id);

        return cardOriginService.findById(id);
    }

    @PostMapping
    public CardOrigin createCardOrigin(@RequestBody CreateCardOriginRequest createCardOriginRequest) {
        return cardOriginService.createCardOrigin(createCardOriginRequest);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("{id}")
    public void deleteCard(@PathVariable("id") long id) {
        LOG.info("Deletando card origin com id [{}]", id);
        cardOriginService.deleteCard(id);
    }

    @PutMapping("{id}")
    public CardOrigin updateCard(@PathVariable("id") long id, @RequestBody UpdateCardOriginRequest updateCardOriginRequest) {
        LOG.info("Atualizando card com id [{}]", id);
        return cardOriginService.update(id, updateCardOriginRequest);
    }
}