package com.decklybuytcg.backend.service;

import com.decklybuytcg.backend.model.Card;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardService {

    // URL de la API TCGDex v2 (en inglés)
    private final String API_URL = "https://api.tcgdex.net/v2/en/cards/";

    public Card getCardById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        Card card = restTemplate.getForObject(API_URL + id, Card.class);
        return card;
    }
}
