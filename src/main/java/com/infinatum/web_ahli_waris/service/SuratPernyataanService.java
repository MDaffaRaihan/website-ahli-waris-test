package com.infinatum.web_ahli_waris.service;

import com.infinatum.web_ahli_waris.models.SuratPernyataan;

import java.util.List;

public interface SuratPernyataanService {
    List<SuratPernyataan> getAllSuratPernyataan();
    SuratPernyataan getSuratPernyataanById(Long id);
    SuratPernyataan createSuratPernyataan(SuratPernyataan suratPernyataan);
    SuratPernyataan updateSuratPernyataan(Long id, SuratPernyataan suratPernyataan);
    boolean deleteSuratPernyataan(Long id);
}
