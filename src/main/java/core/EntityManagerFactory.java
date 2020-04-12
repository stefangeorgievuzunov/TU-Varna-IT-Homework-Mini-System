package core;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class EntityManagerFactory {
       @Produces
    public EntityManager entityManager() {
        return Persistence.createEntityManagerFactory("it_homerwork")
                .createEntityManager();
    }
}
