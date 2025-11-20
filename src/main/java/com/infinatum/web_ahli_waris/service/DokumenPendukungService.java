package com.infinatum.web_ahli_waris.service;

import com.infinatum.web_ahli_waris.models.DokumenPendukung;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DokumenPendukungService {
    List<DokumenPendukung> getAllDokumenPendukung();
    DokumenPendukung getDokumenPendukungById(Long id);
    DokumenPendukung createDokumenPendukung(String NamaAlm, String FileLabel, MultipartFile multipartFile) throws IOException;
    DokumenPendukung updateDokumenPendukung(Long id, String NamaAlm, String FileLabel, MultipartFile multipartFile) throws IOException;
    void deleteDokumenPendukung(Long id);
}
