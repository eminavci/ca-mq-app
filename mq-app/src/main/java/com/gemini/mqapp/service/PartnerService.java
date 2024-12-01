package com.gemini.mqapp.service;

import com.gemini.mqapp.model.Partner;
import com.gemini.mqapp.repository.PartnerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartnerService {

    private final PartnerRepo partnerRepo;

    public Partner persist(Partner partner){
        return partnerRepo.save(partner);
    }

    public List<Partner> getAllPartners(){
        return partnerRepo.findAll();
    }

    public Optional<Partner> findById(Long id){
        return partnerRepo.findById(id);
    }

    public boolean deleteById(Long id){
        return findById(id)
                .map(s -> {partnerRepo.deleteById(id); return true;})
                .orElse(false);

    }

}
