package com.postwork4.bedu.service;

import com.postwork4.bedu.persistence.AgendaMemoryDao;
import com.postwork4.bedu.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AgendaService {

    private final ValidadorTelefono validadorTelefono;
    private final AgendaMemoryDao agendaDao;

    @Autowired
    public AgendaService(ValidadorTelefono validadorTelefono, AgendaMemoryDao agendaDao) {
        this.validadorTelefono = validadorTelefono;
        this.agendaDao = agendaDao;
    }

    public Persona guardaPersona(Persona persona) {

        if (!validadorTelefono.isValido(persona.getTelefono())) {
            return null;
        }
        String telefono = validadorTelefono.limpiaNumero(persona.getTelefono());

        persona.setTelefono(telefono);

        return agendaDao.guardaPersona(persona);
    }

    public Set<Persona> getPersonas() {
        return agendaDao.getPersonas();
    }
}