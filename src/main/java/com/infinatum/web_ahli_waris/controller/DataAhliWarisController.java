package com.infinatum.web_ahli_waris.controller;

import com.infinatum.web_ahli_waris.models.DataAhliWaris;
import com.infinatum.web_ahli_waris.service.DataAhliWarisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DataAhliWaris")
public class DataAhliWarisController {

    @Autowired
    private DataAhliWarisService dataAhliWarisService;

    @GetMapping
    public List<DataAhliWaris> getAllDataAhliWaris() {
        return dataAhliWarisService.getAllDataAhliWaris();
    }

    @GetMapping("/{id}")
    public DataAhliWaris getDataAhliWarisById(@PathVariable Long id) {
        return dataAhliWarisService.getDataAhliwarisById(id);
    }

    @PostMapping
    public DataAhliWaris createDataAhliWaris(@RequestBody DataAhliWaris dataAhliWaris) {
        return dataAhliWarisService.createDataAhliWaris(dataAhliWaris);
    }

    @PutMapping("/{id}")
    public DataAhliWaris updateDataAhliWaris(@PathVariable Long id, @RequestBody DataAhliWaris dataAhliWaris) {
        return dataAhliWarisService.updateDataAhliWaris(id, dataAhliWaris);
    }

    @DeleteMapping("/{id}")
    public String deleteDataAhliWaris(@PathVariable Long id) {
        boolean deleted = dataAhliWarisService.deleteDataAhliWaris(id);
        return deleted ? "Data berhasil dihapus" : "Data tidak ditemukan";
    }
}
