package mariapiabaldoin.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mariapiabaldoin.entities.Location;
import mariapiabaldoin.exceptions.NotFoundException;

public class LocationsDAO {

    private final EntityManager entityManager;

    public LocationsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void save(Location newLocation) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newLocation);
        transaction.commit();
        System.out.println("La location " + newLocation+ " è stata salvata");
    }


    public Location getById(long locationId) {
        Location found = entityManager.find(Location.class, locationId);
        if (found == null) throw new NotFoundException(locationId);
        return found;
    }


}
