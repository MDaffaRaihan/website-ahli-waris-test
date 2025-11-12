package com.infinatum.web_ahli_waris.service;

import com.infinatum.web_ahli_waris.models.SuratPernyataan;
import com.infinatum.web_ahli_waris.repository.SuratPernyataanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SuratPernyataanServiceImpl implements SuratPernyataanService {

    @Autowired
    private SuratPernyataanRepo suratPernyataanRepo;

    @Override
    public List<SuratPernyataan> getAllSuratPernyataan() {
        return suratPernyataanRepo.findAll();
    }

    @Override
    public SuratPernyataan getSuratPernyataanById(Long id) {
        return suratPernyataanRepo.findById(id).orElse(null);
    }

    @Override
    public SuratPernyataan createSuratPernyataan(SuratPernyataan suratPernyataan) {
        if (suratPernyataan.getStatus() == null || suratPernyataan.getStatus().isEmpty()) suratPernyataan.setStatus("Belum Tervalidasi");
        return suratPernyataanRepo.save(suratPernyataan);
    }

    @Override
    public SuratPernyataan updateSuratPernyataan(Long id, SuratPernyataan suratPernyataan) {
        SuratPernyataan existing = suratPernyataanRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setNamaAhliwaris(suratPernyataan.getNamaAhliwaris());
            existing.setNamaAlm(suratPernyataan.getNamaAlm());
            existing.setNoSurat(suratPernyataan.getNoSurat());
            existing.setStatus(suratPernyataan.getStatus());
            return suratPernyataanRepo.save(existing);
        }
        return null;
    }

    @Override
    public boolean deleteSuratPernyataan(Long id) {
        if (suratPernyataanRepo.existsById(id)) {
            suratPernyataanRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
