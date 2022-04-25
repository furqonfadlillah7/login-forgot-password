package com.kelompok1.utspbo.service.implementation;

import com.kelompok1.utspbo.service.framework.PendudukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PendudukServiceImpl implements PendudukService {
    private final com.kelompok1.utspbo.repository.PendudukRepository pendudukRepository;

    @Autowired
    public PendudukServiceImpl(com.kelompok1.utspbo.repository.PendudukRepository pendudukRepository) {
        this.pendudukRepository = pendudukRepository;
    }

    @Override
    public List<com.kelompok1.utspbo.entity.Penduduk> getAllPenduduks() {
        return pendudukRepository.findAll();
    }

    @Override
    public Optional<com.kelompok1.utspbo.entity.Penduduk> findById(Long id) {
        return pendudukRepository.findById(id);
    }

    @Override
    public Optional<com.kelompok1.utspbo.entity.Penduduk> findByEmail(String email) {
        return pendudukRepository.findByEmail(email);
    }

    @Override
    public com.kelompok1.utspbo.entity.Penduduk save(com.kelompok1.utspbo.entity.Penduduk std) {
        return pendudukRepository.save(std);
    }

    @Override
    public void deleteById(Long id) {
        pendudukRepository.deleteById(id);
    }
}