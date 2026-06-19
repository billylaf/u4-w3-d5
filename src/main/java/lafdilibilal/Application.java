package lafdilibilal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lafdilibilal.dao.ElementoDAO;
import lafdilibilal.dao.PrestitoDAO;
import lafdilibilal.dao.UtenteDAO;

public class Application {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4-w3-d5");

    public static void main(String[] args) {
        EntityManager em = entityManagerFactory.createEntityManager();

        UtenteDAO UtenteDAO = new UtenteDAO(em);
        ElementoDAO ElementoDAO = new ElementoDAO(em);
        PrestitoDAO PrestitoDAO = new PrestitoDAO(em);

        ///////////////////////////////////////utenti/////////////////////////////////////////////
       /* Utente aldo = new Utente("aldo", "rossi", 123456789);
        Utente giulia = new Utente("giulia", "bianchi", 234567890);
        Utente luca = new Utente("luca", "ferrari", 345678901);
        Utente sara = new Utente("sara", "conti", 456789012);
        Utente marco = new Utente("marco", "romano", 567890123);
        Utente mario = new Utente("mario", "rossi", 678901234);

        UtenteDAO.save(mario);
        UtenteDAO.save(aldo);
        UtenteDAO.save(marco);
        UtenteDAO.save(sara);
        UtenteDAO.save(luca);
        UtenteDAO.save(giulia);


        ///////////////////////////////////////libri/////////////////////////////////////////////
        Libro signoreAnelli = new Libro(9788804703741L, 2019, 1200, "J.R.R. Tolkien", Genere.FANTASY);
        Libro assassinioOrientExpress = new Libro(9788804682046L, 2017, 480, "Agatha Christie", Genere.GIALLO);
        Libro progettoHailMary = new Libro(9788804753197L, 2021, 352, "Andy Weir", Genere.FANTASCIENZA);
        Libro barbari = new Libro(9788806240619L, 2020, 560, "Alessandro Barbero", Genere.STORICO);
        Libro cleanCode = new Libro(9788836007130L, 2023, 680, "Robert C. Martin", Genere.INFORMATICA);

        ElementoDAO.save(signoreAnelli);
        ElementoDAO.save(assassinioOrientExpress);
        ElementoDAO.save(progettoHailMary);
        ElementoDAO.save(barbari);
        ElementoDAO.save(cleanCode);
        ///////////////////////////////////////riviste/////////////////////////////////////////////
        Rivista time = new Rivista(9771123456789L, 2026, 120, Periodicita.SETTIMANALE);
        Rivista nationalGeographic = new Rivista(9779876543210L, 2025, 200, Periodicita.MENSILE);
        Rivista harvardReview = new Rivista(9775555555555L, 2024, 350, Periodicita.SEMESTRALE);
        Rivista economist = new Rivista(9774444444444L, 2026, 100, Periodicita.SETTIMANALE);
        Rivista wired = new Rivista(9773333333333L, 2025, 180, Periodicita.MENSILE);

        ElementoDAO.save(time);
        ElementoDAO.save(nationalGeographic);
        ElementoDAO.save(harvardReview);
        ElementoDAO.save(economist);
        ElementoDAO.save(wired);*/

 /*
        try {
            Utente utente1 = UtenteDAO.findById(5);
            Utente utente2 = UtenteDAO.findById(2);
            Utente utente3 = UtenteDAO.findById(3);

            Elemento elemento1 = ElementoDAO.findById(9);
            Elemento elemento2 = ElementoDAO.findById(2);
            Elemento elemento3 = ElementoDAO.findById(3);

            // Prestito 1 - attivo (non restituito)
            Prestito prestito1 = new Prestito(utente1, elemento1, null);

            // Prestito 2 - restituito in ritardo
            Prestito prestito2 = new Prestito(utente2, elemento2, LocalDate.now().plusDays(55));

            // Prestito 3 - restituito in tempo
            Prestito prestito3 = new Prestito(utente3, elemento3, LocalDate.now().plusDays(10));

           PrestitoDAO.save(prestito1);
            PrestitoDAO.save(prestito2);
            PrestitoDAO.save(prestito3);

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }*/

/////////////////////es1/////////////////////////////
        /* ElementoDAO.removeByIsbn(9771123456789L);*/
//////////////////////////////es2///////////////////////////
        System.out.println(ElementoDAO.findByIsbn(9788804703741L));
//////////////////////////////e3/////////////////////////////////////////
        ElementoDAO.findByAnnoPubblicazione(2021).forEach(System.out::println);
///////////////////////////es4/////////////////////////////////////
        ElementoDAO.findByAutore("Alessandro Barbero").forEach(System.out::println);

        System.out.println("Hello World!");
    }
}
