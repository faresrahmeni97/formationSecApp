package com.example.formationSecApp.repositories;


import com.example.formationSecApp.models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FormationRepository extends JpaRepository<Formation,Long> {}
