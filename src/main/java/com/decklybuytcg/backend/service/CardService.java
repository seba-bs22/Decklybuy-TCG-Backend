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

        // Cambiar la lista original DTOs con imagen /low.jpg
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

        return CardMapper.toDetailDTO(card);
    }

    // ================================
    //  OBTENER TODAS LAS CARTAS
    // ================================
    public List<CardBriefDTO> getPokemonCards(int page) {
    String url = "https://api.tcgdex.net/v2/en/cards";

    // Consumir todas las cartas
    CardBrief[] allCards = restTemplate.getForObject(url, CardBrief[].class);

    if (allCards == null) return List.of();

    // Filtrar solo cartas con imagen valida
    List<CardBrief> withImages = Arrays.stream(allCards)
            .filter(c -> c.getImage() != null && !c.getImage().isBlank())
            .collect(Collectors.toList());

    // PAGINACION (24 por pagina)
    int pageSize = 24;
    int start = (page - 1) * pageSize;
    int end = Math.min(start + pageSize, withImages.size());

    if (start >= withImages.size()) return List.of();

    // Recortar pagina y convertir a DTO
    return withImages.subList(start, end).stream()
            .map(CardMapper::toBriefDTO)
            .collect(Collectors.toList());
}

}
