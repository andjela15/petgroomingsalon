package com.example.petgrooming.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vlasnici")
public class Vlasnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vlasnikId;

    private String ime;
    private String prezime;
    private String telefon;
    private String email;

    public Vlasnik() {
    }

    public Vlasnik(Long vlasnikId, String ime, String prezime, String telefon, String email) {
        this.vlasnikId = vlasnikId;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
    }

    public Long getVlasnikId() {
        return vlasnikId;
    }

    public void setVlasnikId(Long vlasnikId) {
        this.vlasnikId = vlasnikId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}