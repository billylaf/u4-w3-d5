package lafdilibilal.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "elemento_id", nullable = false)
    private Elemento elemento;

    private LocalDate inizio_prestito;
    private LocalDate restituzione_prevista;
    private LocalDate restituzione_effettiva;


    public Prestito() {

    }

    public Prestito(Utente utente, Elemento elemento, LocalDate restituzione_effettiva) {
        this.utente = utente;
        this.elemento = elemento;
        this.inizio_prestito = LocalDate.now();
        this.restituzione_prevista = this.inizio_prestito.plusDays(30);
        this.restituzione_effettiva = restituzione_effettiva;
    }

    public Long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public Elemento getElemento() {
        return elemento;
    }

    public LocalDate getInizio_prestito() {
        return inizio_prestito;
    }

    public LocalDate getRestituzione_prevista() {
        return restituzione_prevista;
    }

    public LocalDate getRestituzione_effettiva() {
        return restituzione_effettiva;
    }

    public void setRestituzione_effettiva(LocalDate restituzione_effettiva) {
        this.restituzione_effettiva = restituzione_effettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", elemento=" + elemento +
                ", inizio_prestito=" + inizio_prestito +
                ", restituzione_prevista=" + restituzione_prevista +
                ", restituzione_effettiva=" + restituzione_effettiva +
                '}';
    }
}
