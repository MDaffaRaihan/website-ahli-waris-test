package com.infinatum.web_ahli_waris.service;

import com.infinatum.web_ahli_waris.models.DataAhliWaris;
import com.infinatum.web_ahli_waris.repository.DataAhliWarisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataAhliWarisServiceImpl implements DataAhliWarisService{

    @Autowired
    private DataAhliWarisRepo dataAhliWarisRepo;

    @Override
    public List<DataAhliWaris> getAllDataAhliWaris() {
        return dataAhliWarisRepo.findAll();
    }

    @Override
    public DataAhliWaris getDataAhliwarisById(Long id) {
        return dataAhliWarisRepo.findById(id).orElse(null);
    }

    @Override
    public DataAhliWaris createDataAhliWaris(DataAhliWaris dataAhliWaris) {
        if (dataAhliWaris.getStatus() == null || dataAhliWaris.getStatus().isEmpty()) dataAhliWaris.setStatus("Belum Tervalidasi");
        return dataAhliWarisRepo.save(dataAhliWaris);
    }

    @Override
    public DataAhliWaris updateDataAhliWaris(Long id, DataAhliWaris dataAhliWaris) {
        DataAhliWaris existing = dataAhliWarisRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setNamaAhliWaris(dataAhliWaris.getNamaAhliWaris());
            existing.setNIK(dataAhliWaris.getNIK());
            existing.setHubungan(dataAhliWaris.getHubungan());
            existing.setNamaAlm(dataAhliWaris.getNamaAlm());
            existing.setAlamat(dataAhliWaris.getAlamat());
            existing.setStatus(dataAhliWaris.getStatus());
            return dataAhliWarisRepo.save(existing);
        }
        return null;
    }

    @Override
    public boolean deleteDataAhliWaris(Long id) {
        if (dataAhliWarisRepo.existsById(id)) {
            dataAhliWarisRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
