package lafdilibilal.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lafdilibilal.entities.Prestito;


public class PrestitoDAO {
    private final EntityManager entityManager;


    public PrestitoDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(Prestito newPrestito) {


        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        this.entityManager.persist(newPrestito);

        transaction.commit();

        System.out.println("il prestito" + newPrestito + " e' stato salvato nel DB");

    }

    public Prestito findById(int id) {
        Prestito fromDB = this.entityManager.find(Prestito.class, id);
        if (fromDB == null) {
            throw new RuntimeException("prestito con ID " + id + " non trovato");
        }
        return fromDB;
    }
}
