package com.kelompok1.utspbo.controller;

import com.kelompok1.utspbo.service.framework.PendudukService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class PendudukWebController {
    private PendudukService pendudukService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("penduduk", pendudukService.getAllPenduduks());
        return "indexPenduduk";
    }

    @GetMapping(value = "/create")
    public String create1(Model model) {
        model.addAttribute("penduduk", new com.kelompok1.utspbo.entity.Penduduk());
        return "formPenduduk";
    }

    @PostMapping(value = "/create")
    public String tambahStudent(Model model, com.kelompok1.utspbo.entity.Penduduk penduduk) {
        model.addAttribute("penduduk", pendudukService.save(penduduk));
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("penduduk", pendudukService.findById(id));
        return "formStudent";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusStudent(@PathVariable Long id) {
        pendudukService.deleteById(id);
        return "redirect:/";
    }
}