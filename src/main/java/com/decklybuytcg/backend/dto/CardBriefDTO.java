package com.decklybuytcg.backend.dto;

public class CardBriefDTO {

    private String id;
    private String nombre;
    private String img;

    public CardBriefDTO() {}

    public CardBriefDTO(String id, String nombre, String img) {
        this.id = id;
        this.nombre = nombre;
        this.img = img;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }
}
