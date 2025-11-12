package com.infinatum.web_ahli_waris.service;

import com.infinatum.web_ahli_waris.models.DataAlmarhum;
import com.infinatum.web_ahli_waris.repository.DataAlmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DataAlmServiceImpl implements DataAlmService{

    @Autowired
    private DataAlmRepo dataAlmRepo;

    @Override
    public List<DataAlmarhum> getAllDataAlm() {
        return dataAlmRepo.findAll();
    }

    @Override
    public DataAlmarhum getDataAlmById(Long id) {
        return dataAlmRepo.findById(id).orElse(null);
    }

    @Override
    public  DataAlmarhum createDataAlm(DataAlmarhum dataAlmarhum) {
        if (dataAlmarhum.getStatus() == null || dataAlmarhum.getStatus().isEmpty()) dataAlmarhum.setStatus("Belum Tervalidasi");
        dataAlmarhum.setTglPengajuan(LocalDateTime.now());
        return dataAlmRepo.save(dataAlmarhum);
    }

    @Override
    public DataAlmarhum updateDataAlm(Long id, DataAlmarhum updated) {
        DataAlmarhum existing = dataAlmRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setNamaAlm(updated.getNamaAlm());
            existing.setTglKematian(updated.getTglKematian());
            existing.setAlamat(updated.getAlamat());
            existing.setNamaPengaju(updated.getNamaPengaju());
            existing.setStatus(updated.getStatus());
            return dataAlmRepo.save(existing);
        }
        return null;
    }

    @Override
    public boolean deleteDataAlm(Long id) {
        if (dataAlmRepo.existsById(id)) {
            dataAlmRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
