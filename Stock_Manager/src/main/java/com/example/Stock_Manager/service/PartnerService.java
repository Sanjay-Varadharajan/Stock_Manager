package com.example.Stock_Manager.service;


import com.example.Stock_Manager.model.Partners;
import com.example.Stock_Manager.repository.PartnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerService {


    @Autowired
    PartnerRepo partnerRepo;

    public List<Partners> getallpartner() {
        return partnerRepo.findAll();
    }

    public String addpartner(Partners partners) {
        Optional<Partners> check=partnerRepo.findById(partners.getPartnerId());

        if(check.isPresent()){
            return "Already Partner Available";
        }

        partnerRepo.save(partners);
        return "Added Sucessfully";
    }

    public String updatepartner(Partners partners) {
        Optional<Partners> check=partnerRepo.findById(partners.getPartnerId());

        if(check.isEmpty()){
            return "Data Not Available";
        }

        Partners part=check.get();

        part.setPartnerName(partners.getPartnerName());
        part.setPercentage(partners.getPercentage());
        part.setPartnerphoneNumber(partners.getPartnerphoneNumber());


        partnerRepo.save(part);
        return "Data added Sucessfully";
    }


    public String deletepartner(Partners partners) {

        Optional<Partners> check=partnerRepo.findById(partners.getPartnerId());


        if(check.isEmpty()){
            return "Data Not Available";
        }


        partnerRepo.deleteById(partners.getPartnerId());

        return "Data Deleted Sucessfully";
    }

    public Optional<Partners> getpartner(int partnerId) {
        Optional<Partners> check=partnerRepo.findById(partnerId);

        if(check.isEmpty()){
            throw new RuntimeException("Data Not Found.");
        }

        return partnerRepo.findById(partnerId);


    }
}
