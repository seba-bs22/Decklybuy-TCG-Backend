package com.decklybuytcg.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("DecklyBuy-TCG API")
                        .version("v1.0")
                        .description("Backend API para marketplace de cartas TCG, permite buscar cartas por ID o nombre y obtener detalles.")
                );
    }
}
