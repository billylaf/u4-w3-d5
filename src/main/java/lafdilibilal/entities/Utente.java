package lafdilibilal.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String cognome;

    @Column(unique = true, nullable = false)
    private int n_tessera;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Prestito> prestiti;


    public Utente() {
    }

    public Utente(String nome, String cognome, int n_tessera) {

        this.nome = nome;
        this.cognome = cognome;
        this.n_tessera = n_tessera;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getN_tessera() {
        return n_tessera;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", n_tessera=" + n_tessera +
                '}';
    }
}
