package com.infinatum.web_ahli_waris.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pengurus_surat_kuasa")
public class PengurusSuratKuasa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String NamaPengurus;
    private String Hubungan;
    private String NamaAlm;
    private String FileSuratKuasa;
    private String Status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaPengurus() {
        return NamaPengurus;
    }

    public void setNamaPengurus(String namaPengurus) {
        NamaPengurus = namaPengurus;
    }

    public String getHubungan() {
        return Hubungan;
    }

    public void setHubungan(String hubungan) {
        Hubungan = hubungan;
    }

    public String getNamaAlm() {
        return NamaAlm;
    }

    public void setNamaAlm(String namaAlm) {
        NamaAlm = namaAlm;
    }

    public String getFileSuratKuasa() {
        return FileSuratKuasa;
    }

    public void setFileSuratKuasa(String fileSuratKuasa) {
        FileSuratKuasa = fileSuratKuasa;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
