package com.example.formationSecApp.controller;

import com.example.formationSecApp.models.Organisme;
import com.example.formationSecApp.repositories.OrganismeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrganismeController {
    private static final Logger logger = LogManager.getLogger(OrganismeController.class);
    @Autowired
    OrganismeRepository organismeRep;

    @GetMapping("/organismes")
    public List<Organisme> getAllOrganismes() {
        List<Organisme> organismess = organismeRep.findAll();
        return organismess;
    }

    @GetMapping("/organisme/{id}")
    public Organisme getOrganismeById(@PathVariable(value = "id") Long Id) {
        return organismeRep.findById(Id).get();
    }

    @PostMapping("/addorganisme")
    public Organisme createOrganisme(@Valid @RequestBody Organisme organisme) {


        return organismeRep.save(organisme);
    }

    @DeleteMapping("/deleteorganisme/{id}")
    public ResponseEntity<?> deleteOrganisme(@PathVariable(value = "id") Long organismeId) {
        Organisme organisme = organismeRep.findById(organismeId).orElseThrow(null);
        organismeRep.delete(organisme);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateorganisme/{id}")
    public Organisme updateOrganisme(@PathVariable(value = "id") Long id,
                               @Valid @RequestBody Organisme organismeUpdated) {

        Organisme organisme = organismeRep.findById(id).orElseThrow(null);
        organisme.setLibelle(organismeUpdated.getLibelle());
        Organisme updatedOrganisme = organismeRep.save(organisme);
        return updatedOrganisme;
    }
}