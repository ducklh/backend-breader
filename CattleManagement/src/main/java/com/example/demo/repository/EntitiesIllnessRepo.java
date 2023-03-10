package com.example.demo.repository;


import com.example.demo.model.EntitiesIllness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntitiesIllnessRepo extends JpaRepository<EntitiesIllness, String> {
}