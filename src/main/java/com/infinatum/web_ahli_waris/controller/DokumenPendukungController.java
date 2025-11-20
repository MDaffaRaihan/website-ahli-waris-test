package com.infinatum.web_ahli_waris.controller;

import com.infinatum.web_ahli_waris.models.DokumenPendukung;
import com.infinatum.web_ahli_waris.service.DokumenPendukungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/DokumenPendukung")
@CrossOrigin(origins = "*")
public class DokumenPendukungController {

    @Autowired
    private DokumenPendukungService dokumenPendukungService;

    public DokumenPendukungController(DokumenPendukungService dokumenPendukungService) {
        this.dokumenPendukungService = dokumenPendukungService;
    }

    @GetMapping
    public List<DokumenPendukung> getAllDokumenPendukung() {
        return dokumenPendukungService.getAllDokumenPendukung();
    }

    @GetMapping("/{id}")
    public DokumenPendukung getDokumenPendukungById(@PathVariable Long id) {
        return dokumenPendukungService.getDokumenPendukungById(id);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> create(
            @RequestParam String NamaAlm,
            @RequestParam String FileLabel,
            @RequestParam MultipartFile multipartFile
    ) {
        try {
            return ResponseEntity.ok(dokumenPendukungService.createDokumenPendukung(NamaAlm, FileLabel, multipartFile));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Gagal upload: " + e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateData(
            @PathVariable Long id,
            @RequestParam String NamaAlm,
            @RequestParam String FileLabel,
            @RequestParam(required = false) MultipartFile multipartFile
    ) {
        try {
            DokumenPendukung updated = dokumenPendukungService.updateDokumenPendukung(id, NamaAlm, FileLabel, multipartFile);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Gagal update: " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteDokumen(@PathVariable Long id) {
        dokumenPendukungService.deleteDokumenPendukung(id);
        return ResponseEntity.ok("Berhasil menghapus dokumen dan file terkait");
    }
}
