package com.infinatum.web_ahli_waris.repository;

import com.infinatum.web_ahli_waris.models.DokumenPendukung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DokumenPendukungRepo extends JpaRepository<DokumenPendukung, Long> {
}
