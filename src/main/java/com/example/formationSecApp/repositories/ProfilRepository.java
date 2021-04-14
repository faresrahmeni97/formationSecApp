package com.example.formationSecApp.repositories;

import com.example.formationSecApp.models.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilRepository extends JpaRepository<Profil,Long> {}