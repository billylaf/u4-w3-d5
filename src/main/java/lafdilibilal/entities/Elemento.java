package lafdilibilal.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "elementi")
@Inheritance(strategy = InheritanceType.JOINED)
public class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titolo;

    @Column(unique = true, nullable = false)
    private long isbn;

    private int anno_pubblicazione;
    private int n_pagine;

    @OneToMany(mappedBy = "elemento", cascade = CascadeType.ALL)
    private List<Prestito> prestiti;

    public Elemento() {

    }

    public Elemento(long isbn, String titolo, int anno_pubblicazione, int n_pagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.anno_pubblicazione = anno_pubblicazione;
        this.n_pagine = n_pagine;
    }

    public long getId() {
        return id;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public int getN_pagine() {
        return n_pagine;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", isbn=" + isbn +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", n_pagine=" + n_pagine +
                ", prestiti=" + prestiti +
                '}';
    }
}

