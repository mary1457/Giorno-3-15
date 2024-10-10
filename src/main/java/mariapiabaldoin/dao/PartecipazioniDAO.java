package mariapiabaldoin.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mariapiabaldoin.entities.Partecipazione;
import mariapiabaldoin.exceptions.NotFoundException;

public class PartecipazioniDAO {

    private final EntityManager entityManager;

    public PartecipazioniDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void save(Partecipazione newPartecipazione) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newPartecipazione);
        transaction.commit();
        System.out.println("La partecipazione " + newPartecipazione+ " è stata salvata");
    }


    public Partecipazione getById(long partecipazioneId) {
        Partecipazione found = entityManager.find(Partecipazione.class, partecipazioneId);
        if (found == null) throw new NotFoundException(partecipazioneId);
        return found;
    }

}

