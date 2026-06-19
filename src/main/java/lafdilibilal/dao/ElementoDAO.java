package lafdilibilal.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import lafdilibilal.entities.Elemento;
import lafdilibilal.entities.Libro;

import java.util.List;

public class ElementoDAO {


    private final EntityManager entityManager;


    public ElementoDAO(EntityManager em) {
        this.entityManager = em;
    }

    public void save(Elemento newElemento) {


        EntityTransaction transaction = this.entityManager.getTransaction();

        transaction.begin();

        this.entityManager.persist(newElemento);

        transaction.commit();

        System.out.println("l'elemento" + newElemento + " e' stato salvato nel DB");

    }

    public Elemento findById(int id) {
        Elemento fromDB = this.entityManager.find(Elemento.class, id);
        if (fromDB == null) {
            throw new RuntimeException("elemento con ID " + id + " non trovato");
        }
        return fromDB;
    }

    public void removeByIsbn(long isbn) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Query query = entityManager.createQuery("DELETE FROM Elemento e WHERE e.isbn = :isbn")
                .setParameter("isbn", isbn);
        query.executeUpdate();
        transaction.commit();
    }

    public Elemento findByIsbn(long isbn) {
        TypedQuery<Elemento> query = this.entityManager.createQuery(
                "SELECT e FROM Elemento e WHERE e.isbn = :isbn", Elemento.class);
        query.setParameter("isbn", isbn);
        return query.getResultStream().findFirst().orElse(null);
    }

    public List<Elemento> findByAnnoPubblicazione(int anno) {
        TypedQuery<Elemento> query = this.entityManager.createQuery(
                "SELECT e FROM Elemento e WHERE e.anno_pubblicazione = :anno", Elemento.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List<Libro> findByAutore(String autore) {
        TypedQuery<Libro> query = this.entityManager.createQuery(
                "SELECT x FROM Libro x WHERE LOWER(x.autore) LIKE LOWER(:autore)", Libro.class);
        query.setParameter("autore", "%" + autore + "%");
        return query.getResultList();
    }

}
