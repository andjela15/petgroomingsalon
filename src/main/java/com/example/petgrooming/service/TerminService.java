package com.example.petgrooming.service;

import com.example.petgrooming.model.Termin;
import com.example.petgrooming.repository.TerminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminService {

    private final TerminRepository terminRepository;

    public TerminService(TerminRepository terminRepository) {
        this.terminRepository = terminRepository;
    }

    public List<Termin> getAll() {
        return terminRepository.findAll();
    }

    public Termin getById(Long id) {
        return terminRepository.findById(id).orElse(null);
    }

    public Termin save(Termin termin) {
        return terminRepository.save(termin);
    }

    public Termin update(Long id, Termin noviTermin) {
        Termin termin = terminRepository.findById(id).orElse(null);

        if (termin == null) {
            return null;
        }

        termin.setDatumVreme(noviTermin.getDatumVreme());
        termin.setUsluga(noviTermin.getUsluga());
        termin.setStatus(noviTermin.getStatus());
        termin.setNapomena(noviTermin.getNapomena());
        termin.setLjubimacId(noviTermin.getLjubimacId());

        return terminRepository.save(termin);
    }

    public void delete(Long id) {
        terminRepository.deleteById(id);
    }
}
