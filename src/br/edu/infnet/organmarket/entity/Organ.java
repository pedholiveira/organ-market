package br.edu.infnet.organmarket.entity;

import java.math.BigDecimal;

public class Organ {

    private Long id;
    private String organ;
    private BigDecimal price;
    private String donator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDonator() {
        return donator;
    }

    public void setDonator(String donator) {
        this.donator = donator;
    }

    @Override
    public String toString() {
        return String.format("Organ [organid=%d, organ=%s, price=%s, donator=%s]", id, organ, price.toString(), donator);
    }
}
