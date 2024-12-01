package com.gemini.mqapp.repository;

import com.gemini.mqapp.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepo extends JpaRepository<Partner, Long> {
}
