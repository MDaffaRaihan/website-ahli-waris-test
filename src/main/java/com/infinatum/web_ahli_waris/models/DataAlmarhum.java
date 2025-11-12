package com.infinatum.web_ahli_waris.models;

import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "data_almarhum")
public class DataAlmarhum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String NamaAlm;
    private LocalDate TglKematian;
    private String Alamat;
    private String NamaPengaju;
    private String Status;
    private LocalDateTime TglPengajuan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaAlm() {
        return NamaAlm;
    }

    public void setNamaAlm(String namaAlm) {
        NamaAlm = namaAlm;
    }

    public LocalDate getTglKematian() {
        return TglKematian;
    }

    public void setTglKematian(LocalDate tglKematian) {
        TglKematian = tglKematian;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }

    public String getNamaPengaju() {
        return NamaPengaju;
    }

    public void setNamaPengaju(String namaPengaju) {
        NamaPengaju = namaPengaju;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public LocalDateTime getTglPengajuan() {
        return TglPengajuan;
    }

    public void setTglPengajuan(LocalDateTime tglPengajuan) {
        TglPengajuan = tglPengajuan;
    }
}
