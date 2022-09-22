package com.amefastforward.cardapi.controller;

import com.amefastforward.cardapi.controller.request.CreateCardOriginRequest;
import com.amefastforward.cardapi.model.CardOrigin;
import com.amefastforward.cardapi.service.CardOriginService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;



@RestController
@RequestMapping("/card-origin")
public class CardOriginController {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(CardOriginController.class);

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
}
