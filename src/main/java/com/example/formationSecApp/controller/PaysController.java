package com.example.formationSecApp.controller;


import com.example.formationSecApp.models.Pays;
import com.example.formationSecApp.repositories.PaysRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaysController {
    private static final Logger logger = LogManager.getLogger(PaysController.class);
    @Autowired
    PaysRepository paysRep;

    @GetMapping("/payss")
    public List<Pays> getAllPayss() {
        List<Pays> payss = paysRep.findAll();
        return payss;
    }

    @GetMapping("/pays/{id}")
    public Pays getPaysById(@PathVariable(value = "id") Long Id) {
        return paysRep.findById(Id).orElseThrow(null);
    }

    @PostMapping("/addpays")
    public Pays createPays(@Valid @RequestBody Pays pays) {
        return paysRep.save(pays);
    }

    @DeleteMapping("/pays/{id}")
    public ResponseEntity<?> deletePays(@PathVariable(value = "id") Long paysId) {
        Pays pays = paysRep.findById(paysId).orElseThrow(null);
        paysRep.delete(pays);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updatepays/{id}")
    public Pays updatePays(@PathVariable(value = "id") Long id,
                               @Valid @RequestBody Pays paysUpdated) {

        Pays pays = paysRep.findById(id).orElseThrow(null);
        pays.setLibelle(paysUpdated.getLibelle());
        Pays updatedPays = paysRep.save(pays);
        return updatedPays;
    }
}