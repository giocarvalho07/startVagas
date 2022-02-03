package com.ionix.repository;

import com.ionix.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository< Vaga, Long> {

}
