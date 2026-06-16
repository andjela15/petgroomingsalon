package com.example.petgrooming.service;

import com.example.petgrooming.model.Vlasnik;
import com.example.petgrooming.repository.VlasnikRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VlasnikService {

    private final VlasnikRepository vlasnikRepository;

    public VlasnikService(VlasnikRepository vlasnikRepository) {
        this.vlasnikRepository = vlasnikRepository;
    }

    public List<Vlasnik> getAll() {
        return vlasnikRepository.findAll();
    }

    public Vlasnik getById(Long id) {
        return vlasnikRepository.findById(id).orElse(null);
    }

    public Vlasnik save(Vlasnik vlasnik) {
        return vlasnikRepository.save(vlasnik);
    }

    public Vlasnik update(Long id, Vlasnik noviVlasnik) {
        Vlasnik vlasnik = vlasnikRepository.findById(id).orElse(null);

        if (vlasnik == null) {
            return null;
        }

        vlasnik.setIme(noviVlasnik.getIme());
        vlasnik.setPrezime(noviVlasnik.getPrezime());
        vlasnik.setTelefon(noviVlasnik.getTelefon());
        vlasnik.setEmail(noviVlasnik.getEmail());

        return vlasnikRepository.save(vlasnik);
    }

    public void delete(Long id) {
        vlasnikRepository.deleteById(id);
    }
}
