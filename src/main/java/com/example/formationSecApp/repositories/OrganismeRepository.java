package com.example.formationSecApp.repositories;
import com.example.formationSecApp.models.Organisme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganismeRepository extends JpaRepository<Organisme,Long> {}