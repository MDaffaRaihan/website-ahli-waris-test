package com.infinatum.web_ahli_waris.controller;

import com.infinatum.web_ahli_waris.models.DataAlmarhum;
import com.infinatum.web_ahli_waris.service.DataAlmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DataAlmarhum")
public class DataAlmController {

    @Autowired
    private DataAlmService dataAlmService;

    @GetMapping
    public List<DataAlmarhum> getAllDataAlm() {
        return dataAlmService.getAllDataAlm();
    }

    @GetMapping("/{id}")
    public DataAlmarhum getDataAlmById(@PathVariable Long id) {
        return dataAlmService.getDataAlmById(id);
    }

    @PostMapping
    public DataAlmarhum createDataAlm(@RequestBody DataAlmarhum dataAlmarhum) {
        return dataAlmService.createDataAlm(dataAlmarhum);
    }

    @PutMapping("/{id}")
    public DataAlmarhum updateDataAlm(@PathVariable Long id, @RequestBody DataAlmarhum dataAlmarhum) {
        return dataAlmService.updateDataAlm(id, dataAlmarhum);
    }

    @DeleteMapping("/{id}")
    public String deleteDataAlm(@PathVariable Long id) {
        boolean deleted = dataAlmService.deleteDataAlm(id);
        return deleted ? "Data berhasil dihapus" : "Data tidak ditemukan";
    }
}
