package com.example.formationSecApp.controller;

import com.example.formationSecApp.models.Formation;
import com.example.formationSecApp.repositories.FormationRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FormationController {
    private static final Logger logger = LogManager.getLogger(FormationController.class);
    @Autowired
    FormationRepository formationRep;

    @GetMapping("/formations")
    @JsonIgnore
    public List<Formation> getAllFormations() {
        List<Formation> formationss = formationRep.findAll();
        return formationss;
    }

    @GetMapping("/formation/{id}")
    @JsonIgnore
    public Formation getFormationById(@PathVariable(value = "id") Long Id) {
        return formationRep.findById(Id).orElseThrow(null);
    }

    @PostMapping("/addformation")
    public Formation createFormation(@Valid @RequestBody Formation formation) {
        return formationRep.save(formation);
    }

    @DeleteMapping("/deleteformation/{id}")
    public ResponseEntity<?> deleteFormation(@PathVariable(value = "id") Long formationId) {
        Formation formation = formationRep.findById(formationId).orElseThrow(null);
        formationRep.delete(formation);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateformation/{id}")
    public Formation updateFormation(@PathVariable(value = "id") Long id,
                               @Valid @RequestBody Formation formationUpdated) {

        Formation formation = formationRep.findById(id).orElseThrow(null);
        formation.setTitre(formationUpdated.getTitre());
        formation.setBudget(formationUpdated.getBudget());
        formation.setDuree(formationUpdated.getDuree());
        formation.setType_formation(formation.getType_formation());
        formation.setNbSession(formationUpdated.getNbSession());
        formation.setDomaine(formationUpdated.getDomaine());
        Formation updatedFormation = formationRep.save(formation);
        return updatedFormation;
    }
}