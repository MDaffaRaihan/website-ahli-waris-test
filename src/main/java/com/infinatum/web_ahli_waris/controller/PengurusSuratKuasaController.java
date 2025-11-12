package com.infinatum.web_ahli_waris.controller;

import com.infinatum.web_ahli_waris.models.PengurusSuratKuasa;
import com.infinatum.web_ahli_waris.service.PengurusSuratKuasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@RequestMapping("/PengurusSuratKuasa")
public class PengurusSuratKuasaController {

    @Autowired
    private PengurusSuratKuasaService pengurusSuratKuasaService;

    private final String uploadDir = "uploads/";

    @GetMapping
    public List<PengurusSuratKuasa> getAllSuratKuasaService() {
        return pengurusSuratKuasaService.getAllPengurusSuratKuasa();
    }

    @GetMapping("/{id}")
    public PengurusSuratKuasa getSuratKuasaServiceById(@PathVariable Long id) {
        return pengurusSuratKuasaService.getPengurusSuratKuasaById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(
            @RequestParam("namaPengurus") String NamaPengurus,
            @RequestParam("hubungan") String Hubungan,
            @RequestParam("namaAlm") String NamaAlm,
            @RequestParam(value = "fileSuratKuasa", required = false)MultipartFile file,
            @RequestParam(value = "status", required = false) String Status
            ) {
        try {
            PengurusSuratKuasa pengurus = new PengurusSuratKuasa();
            pengurus.setNamaPengurus(NamaPengurus);
            pengurus.setHubungan(Hubungan);
            pengurus.setNamaAlm(NamaAlm);
            pengurus.setStatus(Status != null ? Status : "Belum Tervalidasi");

            String uploadDir = System.getProperty("user.dir") + "/uploads";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
                System.out.println("Folder uploads dibuat di: " + uploadPath.toAbsolutePath());
            }

            if (file != null && !file.isEmpty()) {
                String originName = file.getOriginalFilename();
                String safeFileName = System.currentTimeMillis() + "_" + originName.replaceAll("[^a-zA-Z0-9\\.\\-_]","_");

                Path filePath = uploadPath.resolve(safeFileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                pengurus.setFileSuratKuasa(safeFileName);

                System.out.println("File tersimpan di: " + filePath.toAbsolutePath());
            }

            PengurusSuratKuasa saved = pengurusSuratKuasaService.createPengurusSuratKuasa(pengurus);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Gagal upload file: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Long id,
            @RequestParam("namaPengurus") String NamaPengurus,
            @RequestParam("hubungan") String Hubungan,
            @RequestParam("namaAlm") String NamaAlm,
            @RequestParam(value = "fileSuratKuasa", required = false)MultipartFile file,
            @RequestParam(value = "status") String Status
    ) {
        String fileName = null;

        if (file != null && !file.isEmpty()) {
            try {
                new File(uploadDir).mkdirs();
                fileName = System.currentTimeMillis() + "_" + StringUtils.cleanPath(file.getOriginalFilename());
                file.transferTo(new File(uploadDir + fileName));
            } catch (Exception e) {
                return ResponseEntity.internalServerError().body("Gagal upload file: " + e.getMessage());
            }
        }

        PengurusSuratKuasa existing = pengurusSuratKuasaService.getPengurusSuratKuasaById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        existing.setNamaPengurus(NamaPengurus);
        existing.setHubungan(Hubungan);
        existing.setNamaAlm(NamaAlm);
        if (fileName != null) existing.setFileSuratKuasa(fileName);
        existing.setStatus(Status);

        return ResponseEntity.ok(pengurusSuratKuasaService.updatePengurusSuratKuasa(id, existing));
    }

    @DeleteMapping("/{id}")
    public String deletePengurusSuratKuasa(@PathVariable Long id) {
        boolean delete = pengurusSuratKuasaService.deletePengurusSuratKuasa(id);
        return delete ? "Data berhasil dihapus" : "Data tidak ditemukan";
    }
}
