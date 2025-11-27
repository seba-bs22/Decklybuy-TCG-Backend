package com.decklybuytcg.backend.controller;

import com.decklybuytcg.backend.model.Card;
import com.decklybuytcg.backend.service.CardService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
@Tag(name = "Cartas", description = "Operaciones para buscar cartas")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @GetMapping("/{id}")
    public Card getCardById(@PathVariable String id) {
        return cardService.getCardById(id);
    }

    // Endpoint para busqueda por nombre
    @GetMapping("/search")
    public List<Card> searchCardsByName(@RequestParam String name) {
        return cardService.searchCardsByName(name);
    }
}
