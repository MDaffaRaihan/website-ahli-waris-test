package com.infinatum.web_ahli_waris.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "dokumen_pendukung")
public class DokumenPendukung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String NamaAlm;
    private LocalDate TglUpload;
    private String Status = "belum di validasi";
    private String FilePath;
    private String FileLabel;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNamaAlm() {
        return NamaAlm;
    }

    public void setNamaAlm(String namaAlm) {
        NamaAlm = namaAlm;
    }

    public LocalDate getTglUpload() {
        return TglUpload;
    }

    public void setTglUpload(LocalDate tglUpload) {
        TglUpload = tglUpload;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    public String getFileLabel() {
        return FileLabel;
    }

    public void setFileLabel(String fileLabel) {
        FileLabel = fileLabel;
    }
}
