package com.decklybuytcg.backend.service;

import com.decklybuytcg.backend.dto.CardBriefDTO;
import com.decklybuytcg.backend.dto.CardDetailDTO;
import com.decklybuytcg.backend.model.CardBrief;
import com.decklybuytcg.backend.model.CardDetail;
import com.decklybuytcg.backend.util.CardMapper;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final String API_BY_NAME = "https://api.tcgdex.net/v2/en/cards?name=";
    private final String API_BY_ID   = "https://api.tcgdex.net/v2/en/cards/";

    private final RestTemplate restTemplate = new RestTemplate();

    // ================================
    //  BUSCAR CARTAS POR NOMBRE
    // ================================
    public List<CardBriefDTO> searchByName(String name) {

        CardBrief[] cards = restTemplate.getForObject(
                API_BY_NAME + name,
                CardBrief[].class
        );

        // Convertimos la lista original → DTOs con imagen /low.jpg
        return Arrays.stream(cards)
                .map(CardMapper::toBriefDTO)
                .collect(Collectors.toList());
    }

    // ================================
    //  BUSCAR CARTA POR ID
    // ================================
    public CardDetailDTO findById(String id) {

        CardDetail card = restTemplate.getForObject(
                API_BY_ID + id,
                CardDetail.class
        );

        // Convertimos a DTO
        return CardMapper.toDetailDTO(card);
    }
}
