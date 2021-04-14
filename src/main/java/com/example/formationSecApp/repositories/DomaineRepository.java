package com.example.formationSecApp.repositories;


import com.example.formationSecApp.models.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine,Long> {}
