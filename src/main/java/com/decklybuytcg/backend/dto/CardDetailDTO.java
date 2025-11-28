package com.decklybuytcg.backend.dto;

import java.util.List;

public class CardDetailDTO {

    private String id;
    private String nombre;
    private String img;
    private String categoria;
    private String ilustrador;
    private String rareza;
    private Integer hp;
    private List<String> tipos;
    private String descripcion;

    public CardDetailDTO() {}

    public CardDetailDTO(String id, String nombre, String img, String categoria, String ilustrador,
                         String rareza, Integer hp, List<String> tipos, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.img = img;
        this.categoria = categoria;
        this.ilustrador = ilustrador;
        this.rareza = rareza;
        this.hp = hp;
        this.tipos = tipos;
        this.descripcion = descripcion;
    }

    // Getters y setters:
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getIlustrador() { return ilustrador; }
    public void setIlustrador(String ilustrador) { this.ilustrador = ilustrador; }

    public String getRareza() { return rareza; }
    public void setRareza(String rareza) { this.rareza = rareza; }

    public Integer getHp() { return hp; }
    public void setHp(Integer hp) { this.hp = hp; }

    public List<String> getTipos() { return tipos; }
    public void setTipos(List<String> tipos) { this.tipos = tipos; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
