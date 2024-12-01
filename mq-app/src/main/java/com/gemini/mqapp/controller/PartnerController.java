package com.gemini.mqapp.controller;

import com.gemini.mqapp.model.Partner;
import com.gemini.mqapp.service.PartnerService;
import com.gemini.mqapp.util.QMResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("partner")
@Tag(name = "Partner Controller", description = "For CRUD on Partners")
public class PartnerController {

    private final PartnerService partnerService;

    @Operation(summary = "add a new partner to DB")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public QMResponse<Partner> add(@RequestBody Partner partner) {
        return QMResponse.defaultSuccess(partnerService.persist(partner));
    }

    @Operation(summary = "Get all Partners from DB")
    @GetMapping
    public QMResponse<List<Partner>> getAllPartners() {
        return QMResponse.defaultSuccess(partnerService.getAllPartners());
    }

    @Operation(summary = "Delete a partner")
    @DeleteMapping
    public QMResponse deleteById(@RequestParam(value = "id")  Long id) {
        boolean res = partnerService.deleteById(id);
        return res ? QMResponse.defaultSuccess() : QMResponse.defaultError();
    }

}
