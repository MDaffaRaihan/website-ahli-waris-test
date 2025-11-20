package com.infinatum.web_ahli_waris.service;

import com.infinatum.web_ahli_waris.models.DokumenPendukung;
import com.infinatum.web_ahli_waris.repository.DokumenPendukungRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Service
public class DokumenPendukungServiceImpl implements DokumenPendukungService {

    @Autowired
    private DokumenPendukungRepo dokumenPendukungRepo;

    private String uploadsDir = "uploads/";

    public DokumenPendukungServiceImpl(DokumenPendukungRepo dokumenPendukungRepo) {
        this.dokumenPendukungRepo = dokumenPendukungRepo;

        File dir = new File(uploadsDir);
        if (!dir.exists()) dir.mkdirs();
    }

    private String saveFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile == null || multipartFile.isEmpty()) return null;

        String FileName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        Path FilePath = Paths.get(uploadsDir + FileName);
        Files.write(FilePath, multipartFile.getBytes());
        return FileName;
    }

    @Override
    public List<DokumenPendukung> getAllDokumenPendukung() {
        return dokumenPendukungRepo.findAll();
    }

    @Override
    public DokumenPendukung getDokumenPendukungById(Long id) {
        return dokumenPendukungRepo.findById(id).orElse(null);
    }

    @Override
    public DokumenPendukung createDokumenPendukung(String NamaAlm, String FileLabel, MultipartFile multipartFile) throws IOException {
        DokumenPendukung dokumenPendukung = new DokumenPendukung();
        dokumenPendukung.setNamaAlm(NamaAlm);
        dokumenPendukung.setFileLabel(FileLabel);
        dokumenPendukung.setFilePath(saveFile(multipartFile));
        dokumenPendukung.setTglUpload(LocalDate.now());
        return dokumenPendukungRepo.save(dokumenPendukung);
    }

    @Override
    public DokumenPendukung updateDokumenPendukung(Long id, String NamaAlm, String FileLabel, MultipartFile multipartFile) throws IOException {
        DokumenPendukung existing = dokumenPendukungRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak Ditemukan"));

        existing.setNamaAlm(NamaAlm);
        existing.setFileLabel(FileLabel);

        if (multipartFile != null && !multipartFile.isEmpty()) {
            if (existing.getFilePath() != null) {
                Path oldPath = Paths.get(uploadsDir + existing.getFilePath());
                Files.deleteIfExists(oldPath);
            }

            String newFileName = saveFile(multipartFile);
            existing.setFilePath(newFileName);

            existing.setTglUpload(LocalDate.now());
        }

        return dokumenPendukungRepo.save(existing);
    }

    @Override
    public void deleteDokumenPendukung(Long id) {
        DokumenPendukung dokumenPendukung = dokumenPendukungRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        if (dokumenPendukung.getFilePath() != null) {
            File file = new File(dokumenPendukung.getFilePath());
            if (file.exists()) file.delete();
        }

        dokumenPendukungRepo.deleteById(id);
    }
}
