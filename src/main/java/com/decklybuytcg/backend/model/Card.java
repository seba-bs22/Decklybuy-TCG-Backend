package com.decklybuytcg.backend.model;

import java.util.List;

public class Card {

    private String id;
    private String name;
    private String category;
    private String illustrator;
    private String image;
    private String rarity;
    private Integer hp;
    private List<String> types;
    private String description;

    // Constructor vacío
    public Card() {}

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getIllustrator() { return illustrator; }
    public void setIllustrator(String illustrator) { this.illustrator = illustrator; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getRarity() { return rarity; }
    public void setRarity(String rarity) { this.rarity = rarity; }

    public Integer getHp() { return hp; }
    public void setHp(Integer hp) { this.hp = hp; }

    public List<String> getTypes() { return types; }
    public void setTypes(List<String> types) { this.types = types; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
