package com.example.petgrooming.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ljubimci")
public class Ljubimac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ljubimacId;

    private String ime;
    private String vrsta;
    private String rasa;
    private Integer starost;

    @Column(name = "vlasnik_id")
    private Long vlasnikId;

    public Ljubimac() {
    }

    public Ljubimac(Long ljubimacId, String ime, String vrsta, String rasa, Integer starost, Long vlasnikId) {
        this.ljubimacId = ljubimacId;
        this.ime = ime;
        this.vrsta = vrsta;
        this.rasa = rasa;
        this.starost = starost;
        this.vlasnikId = vlasnikId;
    }

    public Long getLjubimacId() {
        return ljubimacId;
    }

    public void setLjubimacId(Long ljubimacId) {
        this.ljubimacId = ljubimacId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public Integer getStarost() {
        return starost;
    }

    public void setStarost(Integer starost) {
        this.starost = starost;
    }

    public Long getVlasnikId() {
        return vlasnikId;
    }

    public void setVlasnikId(Long vlasnikId) {
        this.vlasnikId = vlasnikId;
    }
}
