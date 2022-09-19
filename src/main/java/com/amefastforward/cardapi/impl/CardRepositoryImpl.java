package com.amefastforward.cardapi.impl;

import com.amefastforward.cardapi.model.Card;
import com.amefastforward.cardapi.repository.CardRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CardRepositoryImpl implements CardRepository {

    private final List<Card> cards;

    public CardRepositoryImpl() {
       cards = new ArrayList<>();

       var card =new Card();
       card.setId(1);
       card.setName("Iron Man");
       card.setDescription("Tony Stark");
       card.setStrenght(5);
       card.setSpeed(5);
       card.setSkill(7);
       card.setGear(6);
       card.setIntellect(7);
       card.setImageUrl("url_image_iron_man");
       card.setCreatedAt(LocalDateTime.now());
       card.setUpdatedAt(LocalDateTime.now());

       cards.add(card);
    }

    @Override
    public Optional<Card> findById(int id) {

        return cards.stream().filter(card -> card.getId() == id).findFirst();

    }

    @Override
    public Card save(Card card) throws Exception {
        var cardFound = cards.stream()
                .filter(cardInList -> cardInList.getName().equals(card.getName()))
                        .findFirst();

        if (cardFound.isPresent()){
            throw new Exception("Nome [" + card.getName() + "]");
        }

        card.setId(cards.size() + 1);
        cards.add(card);
        return card;
    }
}
