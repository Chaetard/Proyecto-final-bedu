package com.postwork4.bedu.persistence;

import com.postwork4.bedu.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
