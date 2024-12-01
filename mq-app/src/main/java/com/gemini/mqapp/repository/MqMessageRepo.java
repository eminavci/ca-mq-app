package com.gemini.mqapp.repository;

import com.gemini.mqapp.model.QmMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MqMessageRepo extends JpaRepository<QmMessage, Long> {
}
