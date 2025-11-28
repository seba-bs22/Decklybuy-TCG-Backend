package com.decklybuytcg.backend.util;

import com.decklybuytcg.backend.model.CardBrief;
import com.decklybuytcg.backend.model.CardDetail;
import com.decklybuytcg.backend.dto.CardBriefDTO;
import com.decklybuytcg.backend.dto.CardDetailDTO;

public class CardMapper {

    /**
     * Convierte CardDetail (modelo de la API) → CardDetailDTO (respuesta para el frontend)
     */
    public static CardDetailDTO toDetailDTO(CardDetail card) {
        if (card == null) return null;

        // Construcción del URL final de la imagen
        String imgUrl = (card.getImage() != null)
                ? card.getImage() + "/low.jpg"
                : null;

        return new CardDetailDTO(
                card.getId(),
                card.getName(),
                imgUrl,
                card.getCategory(),
                card.getIllustrator(),
                card.getRarity(),
                card.getHp(),
                card.getTypes(),
                card.getDescription()
        );
    }

    /**
     * Convierte CardBrief (modelo de la API) → CardBriefDTO (respuesta simplificada)
     */
    public static CardBriefDTO toBriefDTO(CardBrief card) {
        if (card == null) return null;

        String imgUrl = (card.getImage() != null)
                ? card.getImage() + "/low.jpg"
                : null;

        return new CardBriefDTO(
                card.getId(),
                card.getName(),
                imgUrl
        );
    }
}
