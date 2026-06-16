package com.example.petgrooming.controller;

import com.example.petgrooming.model.Ljubimac;
import com.example.petgrooming.service.LjubimacService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ljubimci")
@CrossOrigin(origins = "*")
public class LjubimacController {

    private final LjubimacService ljubimacService;

    public LjubimacController(LjubimacService ljubimacService) {
        this.ljubimacService = ljubimacService;
    }

    @GetMapping
    public List<Ljubimac> getAll() {
        return ljubimacService.getAll();
    }

    @GetMapping("/{id}")
    public Ljubimac getById(@PathVariable Long id) {
        return ljubimacService.getById(id);
    }

    @PostMapping
    public Ljubimac save(@RequestBody Ljubimac ljubimac) {
        return ljubimacService.save(ljubimac);
    }

    @PutMapping("/{id}")
    public Ljubimac update(@PathVariable Long id, @RequestBody Ljubimac ljubimac) {
        return ljubimacService.update(id, ljubimac);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ljubimacService.delete(id);
    }
}
