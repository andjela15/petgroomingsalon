package com.example.petgrooming.controller;

import com.example.petgrooming.model.Termin;
import com.example.petgrooming.service.TerminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/termini")
@CrossOrigin(origins = "*")
public class TerminController {

    private final TerminService terminService;

    public TerminController(TerminService terminService) {
        this.terminService = terminService;
    }

    @GetMapping
    public List<Termin> getAll() {
        return terminService.getAll();
    }

    @GetMapping("/{id}")
    public Termin getById(@PathVariable Long id) {
        return terminService.getById(id);
    }

    @PostMapping
    public Termin save(@RequestBody Termin termin) {
        return terminService.save(termin);
    }

    @PutMapping("/{id}")
    public Termin update(@PathVariable Long id, @RequestBody Termin termin) {
        return terminService.update(id, termin);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        terminService.delete(id);
    }
}
