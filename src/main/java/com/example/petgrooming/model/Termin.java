package com.example.petgrooming.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "termini")
public class Termin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long terminId;

    private LocalDateTime datumVreme;
    private String usluga;
    private String status;
    private String napomena;

    @Column(name = "ljubimac_id")
    private Long ljubimacId;

    public Termin() {
    }

    public Termin(Long terminId, LocalDateTime datumVreme, String usluga, String status, String napomena, Long ljubimacId) {
        this.terminId = terminId;
        this.datumVreme = datumVreme;
        this.usluga = usluga;
        this.status = status;
        this.napomena = napomena;
        this.ljubimacId = ljubimacId;
    }

    public Long getTerminId() {
        return terminId;
    }

    public void setTerminId(Long terminId) {
        this.terminId = terminId;
    }

    public LocalDateTime getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(LocalDateTime datumVreme) {
        this.datumVreme = datumVreme;
    }

    public String getUsluga() {
        return usluga;
    }

    public void setUsluga(String usluga) {
        this.usluga = usluga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Long getLjubimacId() {
        return ljubimacId;
    }

    public void setLjubimacId(Long ljubimacId) {
        this.ljubimacId = ljubimacId;
    }
}
