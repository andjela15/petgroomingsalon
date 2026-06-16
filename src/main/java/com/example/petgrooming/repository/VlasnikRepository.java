package com.example.petgrooming.repository;

import com.example.petgrooming.model.Vlasnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VlasnikRepository extends JpaRepository<Vlasnik, Long> {
}
