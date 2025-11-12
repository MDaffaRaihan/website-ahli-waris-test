package com.infinatum.web_ahli_waris.controller;

import com.infinatum.web_ahli_waris.models.SuratPernyataan;
import com.infinatum.web_ahli_waris.service.SuratPernyataanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SuratPernyataan")
public class SuratPernyataanController {

    @Autowired
    private SuratPernyataanService suratPernyataanService;

    @GetMapping
    public List<SuratPernyataan> getAllSuratPernyataan() {
        return suratPernyataanService.getAllSuratPernyataan();
    }

    @GetMapping("/{id}")
    public SuratPernyataan getSuratPernyataanById(@PathVariable Long id) {
        return suratPernyataanService.getSuratPernyataanById(id);
    }

    @PostMapping
    public SuratPernyataan createSuratPernyataan(@RequestBody SuratPernyataan suratPernyataan){
        return suratPernyataanService.createSuratPernyataan(suratPernyataan);
    }

    @PutMapping("/{id}")
    public SuratPernyataan updateSuratPernyataan(@PathVariable Long id, @RequestBody SuratPernyataan suratPernyataan) {
        return suratPernyataanService.updateSuratPernyataan(id, suratPernyataan);
    }

    @DeleteMapping("/{id}")
    public String deleteSuratPernyataan(@PathVariable Long id) {
        boolean deleted = suratPernyataanService.deleteSuratPernyataan(id);
        return deleted ? "Data berhasil dihapus" : "Data tidak ditemukan";
    }
}
