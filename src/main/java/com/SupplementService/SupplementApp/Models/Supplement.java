package com.SupplementService.SupplementApp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "supplements")
public class Supplement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String benefits;
    private String evidence;

    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void setBenefits(String benefits){
        this.benefits = benefits;
    }
    public String getBenefits(){
        return this.benefits;
    }

    public void setEvidence(String evidence){
        this.evidence = evidence;
    }
    public String getEvidence(){
        return this.evidence;
    }


    //toString added here for debugging purposes.
    @Override
    public String toString() {
        return "Supplement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", benefits='" + benefits + '\'' +
                ", evidence='" + evidence + '\'' +
                '}';
    }


}
