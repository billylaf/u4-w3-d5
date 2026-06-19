package lafdilibilal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "libri")
public class Libro extends Elemento {

    private String autore;
    @Enumerated(EnumType.STRING)
    private Genere genere;

    public Libro() {

    }

    public Libro(long isbn, int anno_pubblicazione, int n_pagine, String autore, Genere genere) {
        super(isbn, anno_pubblicazione, n_pagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public String toString() {
        return "Libro{" +
                "id=" + getId() +
                ", isbn=" + getIsbn() +
                ", anno_pubblicazione=" + getAnno_pubblicazione() +
                ", n_pagine=" + getN_pagine() +
                ", autore='" + autore + '\'' +
                ", genere=" + genere +
                '}';
    }
}
