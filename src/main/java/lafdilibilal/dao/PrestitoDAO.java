package lafdilibilal.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lafdilibilal.entities.Prestito;

import java.util.List;


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

    public List<Prestito> findPrestitiAttivi(int nTessera) {
        TypedQuery<Prestito> query = this.entityManager.createQuery(
                "SELECT p FROM Prestito p WHERE p.utente.n_tessera = :tessera AND p.restituzione_effettiva IS NULL",
                Prestito.class);
        query.setParameter("tessera", nTessera);
        return query.getResultList();
    }

    public List<Prestito> findScaduti() {
        TypedQuery<Prestito> query = this.entityManager.createQuery(
                "SELECT p FROM Prestito p WHERE p.restituzione_prevista < CURRENT_DATE AND p.restituzione_effettiva IS NULL",
                Prestito.class);
        return query.getResultList();
    }
}
