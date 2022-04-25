package com.kelompok1.utspbo.service.framework;

import java.util.List;
import java.util.Optional;

public interface PendudukService {
    List<com.kelompok1.utspbo.entity.Penduduk> getAllPenduduks();

    Optional<com.kelompok1.utspbo.entity.Penduduk> findById(Long id);

    Optional<com.kelompok1.utspbo.entity.Penduduk> findByEmail(String email);

    com.kelompok1.utspbo.entity.Penduduk save(com.kelompok1.utspbo.entity.Penduduk std);

    void deleteById(Long id);
}
