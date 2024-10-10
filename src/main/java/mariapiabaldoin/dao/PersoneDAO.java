package mariapiabaldoin.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mariapiabaldoin.entities.Persona;
import mariapiabaldoin.exceptions.NotFoundException;

public class PersoneDAO {

    private final EntityManager entityManager;

    public PersoneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void save(Persona newPersona) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPersona);
        transaction.commit();
        System.out.println("La persona " + newPersona + " è stata creata");
    }


    public Persona getById(long personaId) {
        Persona found = entityManager.find(Persona.class, personaId);
        if (found == null) throw new NotFoundException(personaId);
        return found;
    }



}

