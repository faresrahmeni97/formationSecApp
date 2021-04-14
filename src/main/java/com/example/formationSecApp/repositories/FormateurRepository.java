package com.example.formationSecApp.repositories;


import com.example.formationSecApp.models.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur,Long> {}