package com.wildcodeschool.wildandwizard.entity;

import com.wildcodeschool.wildandwizard.repository.SchoolRepository;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String birthPlace;
    private String biography;
    private boolean muggle;

    //permet de faire la jointure grâce à JPA entre Wizard et School
    //LAZY car les relations ne sont chargées qu'au besoin (+rapide).
    //Refresh : met à jour l'entité quand une relation est modifiée ou supprimée.
    //Optional : valeur false, il ne sera pas possible d'y insérer une valeur nulle.
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "school_id")
    private School school;

    public Wizard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public boolean isMuggle() {
        return muggle;
    }

    public void setMuggle(boolean muggle) {
        this.muggle = muggle;
    }

    //setters rajouté ici
    public void setSchool(School school){
        this.school = school;
    };
}