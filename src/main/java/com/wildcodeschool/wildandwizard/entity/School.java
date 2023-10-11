package com.wildcodeschool.wildandwizard.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long capacity;
    private String country;

    //permet de faire la jointure grâce à JPA entre Wizard et School
    //LAZY car les relations ne sont chargées qu'au besoin (+rapide).
    //Refresh : met à jour l'entité quand une relation est modifiée ou supprimée.
    //Optional : valeur false, il ne sera pas possible d'y insérer une valeur nulle.
    @OneToMany(mappedBy = "school")
    private List<Wizard> wizards;

    public School() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //getter ajouté ci-dessous afin de récupérer la list des wizards
    public List<Wizard> getWizards(){
        return wizards;
    }
}