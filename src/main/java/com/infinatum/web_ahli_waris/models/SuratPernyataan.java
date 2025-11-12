package com.infinatum.web_ahli_waris.models;

import jakarta.persistence.*;

@Entity
@Table(name = "surat_pernyataan")
public class SuratPernyataan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String NamaAhliwaris;
    private String NamaAlm;
    private String NoSurat;
    private String Status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaAhliwaris() {
        return NamaAhliwaris;
    }

    public void setNamaAhliwaris(String namaAhliwaris) {
        NamaAhliwaris = namaAhliwaris;
    }

    public String getNamaAlm() {
        return NamaAlm;
    }

    public void setNamaAlm(String namaAlm) {
        NamaAlm = namaAlm;
    }

    public String getNoSurat() {
        return NoSurat;
    }

    public void setNoSurat(String noSurat) {
        NoSurat = noSurat;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
