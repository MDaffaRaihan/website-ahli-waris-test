package com.infinatum.web_ahli_waris.service;

import com.infinatum.web_ahli_waris.models.PengurusSuratKuasa;
import com.infinatum.web_ahli_waris.repository.PengurusSuratKuasaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengurusSuratKuasaServiceImpl implements PengurusSuratKuasaService{

    @Autowired
    private PengurusSuratKuasaRepo pengurusSuratKuasaRepo;

    @Override
    public List<PengurusSuratKuasa> getAllPengurusSuratKuasa() {
        return pengurusSuratKuasaRepo.findAll();
    }

    @Override
    public PengurusSuratKuasa getPengurusSuratKuasaById(Long id) {
        return pengurusSuratKuasaRepo.findById(id).orElse(null);
    }

    @Override
    public PengurusSuratKuasa createPengurusSuratKuasa(PengurusSuratKuasa pengurusSuratKuasa) {
        if (pengurusSuratKuasa.getStatus() == null || pengurusSuratKuasa.getStatus().isEmpty()) {
            pengurusSuratKuasa.setStatus("Belum Tervalidasi");
        }
        return pengurusSuratKuasaRepo.save(pengurusSuratKuasa);
    }

    @Override
    public PengurusSuratKuasa updatePengurusSuratKuasa(Long id, PengurusSuratKuasa updated) {
        PengurusSuratKuasa existing = pengurusSuratKuasaRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setNamaPengurus(updated.getNamaPengurus());
            existing.setHubungan(updated.getHubungan());
            existing.setNamaAlm(updated.getNamaAlm());
            existing.setFileSuratKuasa(updated.getFileSuratKuasa());
            existing.setStatus(updated.getStatus());
            return pengurusSuratKuasaRepo.save(existing);
        }
        return null;
    }

    @Override
    public boolean deletePengurusSuratKuasa(Long id) {
        if (pengurusSuratKuasaRepo.existsById(id)) {
            pengurusSuratKuasaRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
