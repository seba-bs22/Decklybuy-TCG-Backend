package com.decklybuytcg.backend.controller;

import com.decklybuytcg.backend.dto.CardBriefDTO;
import com.decklybuytcg.backend.dto.CardDetailDTO;
import com.decklybuytcg.backend.service.CardService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@Tag(name = "Cartas", description = "Operaciones para buscar cartas")
@CrossOrigin(origins = "http://localhost:5173") // Habilitar CORS (Puerto del Frontend)
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    // ================================
    // BUSCAR POR ID
    // ================================
    @GetMapping("/{id}")
    public CardDetailDTO getCardById(@PathVariable String id) {
        return cardService.findById(id);
    }

    // ================================
    // BUSCAR POR NOMBRE
    // ================================
    @GetMapping("/search")
    public List<CardBriefDTO> searchCardsByName(@RequestParam String name) {
        return cardService.searchByName(name);
    }
}
