package lafdilibilal.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lafdilibilal.entities.Utente;

public class UtenteDAO {
    private final EntityManager entityManager;


    public UtenteDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(Utente newUtente) {


        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        this.entityManager.persist(newUtente);

        transaction.commit();

        System.out.println("l'utente" + newUtente + " e' stato salvato nel DB");

    }

    public Utente findById(int id) {
        Utente fromDB = this.entityManager.find(Utente.class, id);
        if (fromDB == null) {
            throw new RuntimeException("utente con ID " + id + " non trovato");
        }
        return fromDB;
    }
}
