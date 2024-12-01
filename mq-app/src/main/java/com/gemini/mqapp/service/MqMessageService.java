package com.gemini.mqapp.service;

import com.gemini.mqapp.model.QmMessage;
import com.gemini.mqapp.repository.MqMessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MqMessageService {

    private final MqMessageRepo msgRepo;

    public QmMessage persist(String msgId, Long timestamp, String msgText){

        QmMessage qmMessage = QmMessage.builder()
                .messageId(msgId)
                .date(LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("Europe/Paris")))
                .message(msgText).build();
        return msgRepo.save(qmMessage);
    }

    public List<QmMessage> getAllMessages(){
        return msgRepo.findAll();
    }

    public Optional<QmMessage> findById(Long id){
        return msgRepo.findById(id);
    }

}
