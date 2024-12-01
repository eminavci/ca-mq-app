package com.gemini.mqapp.controller;


import com.gemini.mqapp.mq.MqListener;
import com.gemini.mqapp.service.MqMessageService;
import com.gemini.mqapp.util.QMResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("qm")
@Tag(name = "MQ Message Controller", description = "For publish/consume MQ messages")
public class MqAppController {


    private final MqListener mq;
    private final MqMessageService msgService;

    @Operation(summary = "Puplish a text message to MQ broker")
    @PostMapping( consumes = MediaType.TEXT_PLAIN_VALUE)
    public QMResponse send(@RequestBody String message) {
        mq.sendMessage(message);
        return QMResponse.defaultSuccess();
    }

    @Operation(summary = "Get all MQ messages from DB")
    @GetMapping
    public QMResponse getAll() {
        QMResponse qmResponse = QMResponse.defaultSuccess(msgService.getAllMessages());
        return qmResponse;
    }

    @Operation(summary = "Get a MQ Message by id from DB")
    @GetMapping(value = "/{id}")
    public QMResponse getById(@PathVariable Long id) {
       return msgService.findById(id).map(QMResponse::defaultSuccess)
               .orElse(QMResponse.defaultError("No Partner found for id " + id));
    }

}
