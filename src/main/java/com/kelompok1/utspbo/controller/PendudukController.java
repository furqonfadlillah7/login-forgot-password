package com.kelompok1.utspbo.controller;

import com.kelompok1.utspbo.service.framework.PendudukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/penduduk")
public class PendudukController {
    private final PendudukService pendudukservice;

    @Autowired
    public PendudukController(PendudukService pendudukservice) {
        this.pendudukservice = pendudukservice;
    }

    @GetMapping
    public List<com.kelompok1.utspbo.entity.Penduduk> getAllPenduduks() {
        return pendudukservice.getAllPenduduks();
    }

    @GetMapping(value = "/{id}")
    public com.kelompok1.utspbo.entity.Penduduk getStudentById(@PathVariable("id") @Min(1) Long id) {
        com.kelompok1.utspbo.entity.Penduduk std = pendudukservice.findById(id)
                .orElseThrow(() -> new com.kelompok1.utspbo.exception.PendudukNotFoundException("Student with " + id + " is Not Found!"));
        return std;
    }

    @PostMapping
    public com.kelompok1.utspbo.entity.Penduduk addStudent(@Valid @RequestBody com.kelompok1.utspbo.entity.Penduduk std) {
        return pendudukservice.save(std);
    }

    @PutMapping(value = "/{id}")
    public com.kelompok1.utspbo.entity.Penduduk updateStudent(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody com.kelompok1.utspbo.entity.Penduduk newStd) {
        com.kelompok1.utspbo.entity.Penduduk penduduk = pendudukservice.findById(id)
                .orElseThrow(() -> new com.kelompok1.utspbo.exception.PendudukNotFoundException("Student with " + id + " is Not Found!"));
        penduduk.setFirstName(newStd.getFirstName());
        penduduk.setLastName(newStd.getLastName());
        penduduk.setEmail(newStd.getEmail());
        penduduk.setPhone(newStd.getPhone());
        return pendudukservice.save(penduduk);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) Long id) {
        com.kelompok1.utspbo.entity.Penduduk std = pendudukservice.findById(id)
                .orElseThrow(() -> new com.kelompok1.utspbo.exception.PendudukNotFoundException("Student with " + id + " is Not Found!"));
        pendudukservice.deleteById(std.getId());
        return "Student with ID :" + id + " is deleted";
    }
}