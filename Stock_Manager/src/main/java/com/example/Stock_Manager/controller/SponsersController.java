package com.example.Stock_Manager.controller;


import com.example.Stock_Manager.model.Sponsers;
import com.example.Stock_Manager.service.SponsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stocker")
public class SponsersController {

    @Autowired
    SponsersService sponsersService;


    @GetMapping("/sponsers")
    public List<Sponsers> getallsponsers(){
        return sponsersService.getallsponsers();
    }

    @PostMapping("/addsponsers")
    public String addsponsers(@RequestBody Sponsers sponsers){
        return sponsersService.addsponsers(sponsers);
    }

    @PutMapping("/updatesponser")
    public String updatesponser(@RequestBody Sponsers sponsers){
        return sponsersService.updatesponser(sponsers);
    }

    @DeleteMapping("/deletesponser")
    public String deletesponser(@RequestParam("sponserId")int sponserId){
        return  sponsersService.deletesponser(sponserId);
    }
}
