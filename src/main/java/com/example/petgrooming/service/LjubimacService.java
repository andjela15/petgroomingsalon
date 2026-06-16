package com.example.petgrooming.service;

import com.example.petgrooming.model.Ljubimac;
import com.example.petgrooming.repository.LjubimacRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LjubimacService {

    private final LjubimacRepository ljubimacRepository;

    public LjubimacService(LjubimacRepository ljubimacRepository) {
        this.ljubimacRepository = ljubimacRepository;
    }

    public List<Ljubimac> getAll() {
        return ljubimacRepository.findAll();
    }

    public Ljubimac getById(Long id) {
        return ljubimacRepository.findById(id).orElse(null);
    }

    public Ljubimac save(Ljubimac ljubimac) {
        return ljubimacRepository.save(ljubimac);
    }

    public Ljubimac update(Long id, Ljubimac noviLjubimac) {
        Ljubimac ljubimac = ljubimacRepository.findById(id).orElse(null);

        if (ljubimac == null) {
            return null;
        }

        ljubimac.setIme(noviLjubimac.getIme());
        ljubimac.setVrsta(noviLjubimac.getVrsta());
        ljubimac.setRasa(noviLjubimac.getRasa());
        ljubimac.setStarost(noviLjubimac.getStarost());
        ljubimac.setVlasnikId(noviLjubimac.getVlasnikId());

        return ljubimacRepository.save(ljubimac);
    }

    public void delete(Long id) {
        ljubimacRepository.deleteById(id);
    }
}
