package com.infinatum.web_ahli_waris.service;

import com.infinatum.web_ahli_waris.models.DataAhliWaris;

import java.util.List;

public interface DataAhliWarisService {
    public List<DataAhliWaris> getAllDataAhliWaris();
    public DataAhliWaris getDataAhliwarisById(Long id);
    public DataAhliWaris createDataAhliWaris(DataAhliWaris dataAhliWaris);
    public DataAhliWaris updateDataAhliWaris(Long id, DataAhliWaris dataAhliWaris);
    public boolean deleteDataAhliWaris(Long id);
}
