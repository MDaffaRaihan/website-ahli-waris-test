package com.infinatum.web_ahli_waris.service;

import com.infinatum.web_ahli_waris.models.DataAlmarhum;

import java.util.List;

public interface DataAlmService {
    public List<DataAlmarhum> getAllDataAlm();
    public DataAlmarhum getDataAlmById(Long id);
    public  DataAlmarhum createDataAlm(DataAlmarhum dataAlmarhum);
    public DataAlmarhum updateDataAlm(Long id, DataAlmarhum updated);
    public boolean deleteDataAlm(Long id);
}
