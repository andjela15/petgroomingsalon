package com.example.petgrooming.controller;

import com.example.petgrooming.model.Vlasnik;
import com.example.petgrooming.service.VlasnikService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vlasnici")
@CrossOrigin(origins = "*")
public class VlasnikController {

    private final VlasnikService vlasnikService;

    public VlasnikController(VlasnikService vlasnikService) {
        this.vlasnikService = vlasnikService;
    }

    @GetMapping
    public List<Vlasnik> getAll() {
        return vlasnikService.getAll();
    }

    @GetMapping("/{id}")
    public Vlasnik getById(@PathVariable Long id) {
        return vlasnikService.getById(id);
    }

    @PostMapping
    public Vlasnik save(@RequestBody Vlasnik vlasnik) {
        return vlasnikService.save(vlasnik);
    }

    @PutMapping("/{id}")
    public Vlasnik update(@PathVariable Long id, @RequestBody Vlasnik vlasnik) {
        return vlasnikService.update(id, vlasnik);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vlasnikService.delete(id);
    }
}
