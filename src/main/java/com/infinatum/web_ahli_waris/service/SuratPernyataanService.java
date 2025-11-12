package com.infinatum.web_ahli_waris.service;

import com.infinatum.web_ahli_waris.models.SuratPernyataan;

import java.util.List;

public interface SuratPernyataanService {
    public List<SuratPernyataan> getAllSuratPernyataan();
    public SuratPernyataan getSuratPernyataanById(Long id);
    public SuratPernyataan createSuratPernyataan(SuratPernyataan suratPernyataan);
    public SuratPernyataan updateSuratPernyataan(Long id, SuratPernyataan suratPernyataan);
    public boolean deleteSuratPernyataan(Long id);
}
