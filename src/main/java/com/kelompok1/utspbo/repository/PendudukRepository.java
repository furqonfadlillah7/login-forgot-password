package com.kelompok1.utspbo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PendudukRepository extends JpaRepository<com.kelompok1.utspbo.entity.Penduduk, Long> {
    Optional<com.kelompok1.utspbo.entity.Penduduk> findByEmail(String email);
}
