package com.decklybuytcg.backend.service;

import com.decklybuytcg.backend.model.Card;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class CardService {

    // URL de la API TCGDex v2 (en ingles) segun endpoint
    private final String API_URL_BY_ID = "https://api.tcgdex.net/v2/en/cards/";
    private final String API_URL_BY_NAME = "https://api.tcgdex.net/v2/en/cards?name=";

    // Buscar por ID
    public Card getCardById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(API_URL_BY_ID + id, Card.class);
    }

    // Buscar cartas por nombre (devuelve una lista)
    public List<Card> searchCardsByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        Card[] cards = restTemplate.getForObject(API_URL_BY_NAME + name, Card[].class);
        return Arrays.asList(cards);
    }
}
