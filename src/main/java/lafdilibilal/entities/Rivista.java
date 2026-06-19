package lafdilibilal.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "riviste")
public class Rivista extends Elemento {

    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista() {

    }

    public Rivista(long isbn, String titolo, int anno_pubblicazione, int n_pagine, Periodicita periodicita) {
        super(isbn, titolo, anno_pubblicazione, n_pagine);
        this.periodicita = periodicita;

    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "id=" + getId() +
                ", titolo=" + getTitolo() +
                ", isbn=" + getIsbn() +
                ", anno_pubblicazione=" + getAnno_pubblicazione() +
                ", n_pagine=" + getN_pagine() +
                ", periodicita=" + periodicita +
                '}';
    }
}
