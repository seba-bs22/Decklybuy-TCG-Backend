package com.decklybuytcg.backend.model;

public class CardBrief {

    private String id;
    private String localId;
    private String name;
    private String image;

    public CardBrief() {}

    // Getters y setters:
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getLocalId() { return localId; }
    public void setLocalId(String localId) { this.localId = localId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
