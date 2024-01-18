package com.demo.tpProjetsEntreprises;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projets")
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToMany
    @JoinTable(
            name="projets_employes",
            joinColumns = @JoinColumn(name="projet_id"),
            inverseJoinColumns = @JoinColumn(name="participant_id")
    )
    private List<Employe> participants = new ArrayList<>();

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Projet() {
    }

    public Projet(String titre) {
        this.titre = titre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Employe> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Employe> participants) {
        this.participants = participants;
    }

    public void addParticipant(Employe participant) {
        participants.add(participant);
    }

    @Override
    public String toString() {
        return "Projet{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                '}';
    }
}
