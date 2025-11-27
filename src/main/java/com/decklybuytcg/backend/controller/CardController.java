package com.decklybuytcg.backend.controller;

import com.decklybuytcg.backend.model.Card;
import com.decklybuytcg.backend.service.CardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/{id}")
    public Card getCardById(@PathVariable String id) {
        return cardService.getCardById(id);
    }
}
