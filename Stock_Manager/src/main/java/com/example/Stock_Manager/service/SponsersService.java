package com.example.Stock_Manager.service;


import com.example.Stock_Manager.model.Sponsers;
import com.example.Stock_Manager.repository.SponsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SponsersService {


    @Autowired
    SponsersRepo sponsersrepo;

    public List<Sponsers> getallsponsers() {
       return sponsersrepo.findAll();
    }

    public String addsponsers(Sponsers sponsers) {

        Optional<Sponsers> check=sponsersrepo.findById(sponsers.getSponserId());

        if(check.isPresent()){
            return "Data Already Exists..";
        }

        sponsersrepo.save(sponsers);
        return "Data Added Sucessfully..";
    }

    public String updatesponser(Sponsers sponsers) {

        Optional<Sponsers> check=sponsersrepo.findById(sponsers.getSponserId());

        if(check.isEmpty()){
            return "Data Not Found...";
        }

        Sponsers spon=check.get();


        spon.setSponserName(sponsers.getSponserName());
        spon.setFundingAMount(sponsers.getFundingAMount());

        sponsersrepo.save(spon);

        return "Data added Sucessfully..";
    }


    public String deletesponser(int sponserId) {
        Optional<Sponsers> check=sponsersrepo.findById(sponserId);

        if(check.isEmpty()){
            return "Data Not Found...";
        }
        sponsersrepo.deleteById(sponserId);
        return "Data deleted Sucessfully";
    }
}
