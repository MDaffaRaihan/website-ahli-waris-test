package com.infinatum.web_ahli_waris.models;

import jakarta.persistence.*;

@Entity
@Table(name = "data_ahli_waris")
public class DataAhliWaris {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String NamaAhliWaris;
    private long NIK;
    private String Hubungan;
    private String NamaAlm;
    private String Alamat;
    private String Status;

    /*
     * ==============[ TESTING ]==============
     */
    @ManyToOne
    @JoinColumn(name = "dataalmarhum_id")
    private DataAlmarhum dataalmarhum;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaAhliWaris() {
        return NamaAhliWaris;
    }

    public void setNamaAhliWaris(String namaAhliWaris) {
        NamaAhliWaris = namaAhliWaris;
    }

    public long getNIK() {
        return NIK;
    }

    public void setNIK(long NIK) {
        this.NIK = NIK;
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

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
