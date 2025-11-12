package com.infinatum.web_ahli_waris.service;

import com.infinatum.web_ahli_waris.models.PengurusSuratKuasa;

import java.util.List;

public interface PengurusSuratKuasaService {
    public List<PengurusSuratKuasa> getAllPengurusSuratKuasa();
    public PengurusSuratKuasa getPengurusSuratKuasaById(Long id);
    public PengurusSuratKuasa createPengurusSuratKuasa(PengurusSuratKuasa pengurusSuratKuasa);
    public PengurusSuratKuasa updatePengurusSuratKuasa(Long id, PengurusSuratKuasa updated);
    public boolean deletePengurusSuratKuasa(Long id);
}
