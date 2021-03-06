/*Generated by WaveMaker Studio*/

package com.testdb_hsql.rolodex;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;




/**
 * Film generated by hbm2java
 */
@Entity
@Table(name="FILM"
    ,schema="PUBLIC"
)
public class Film  implements java.io.Serializable
 {


private Integer filmId;
private String title;
private String description;
private String releaseYear;
private Integer rentalDuration;
private BigDecimal rentalRate;
private Integer length;
private BigDecimal replacementCost;
private String rating;
private String specialFeatures;
private Set<Inventory> inventories = new HashSet<Inventory>(0);
private Set<FilmActor> filmActors = new HashSet<FilmActor>(0);

    public Film() {
    }



     @Id @GeneratedValue(strategy=IDENTITY)

    

    @Column(name="FILM_ID", nullable=false)
    public Integer getFilmId() {
        return this.filmId;
    }
    
    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    

    @Column(name="TITLE", nullable=false)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    

    @Column(name="DESCRIPTION", length=500)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    

    @Column(name="RELEASE_YEAR", length=4)
    public String getReleaseYear() {
        return this.releaseYear;
    }
    
    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    

    @Column(name="RENTAL_DURATION", nullable=false)
    public Integer getRentalDuration() {
        return this.rentalDuration;
    }
    
    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    

    @Column(name="RENTAL_RATE", nullable=false, precision=4)
    public BigDecimal getRentalRate() {
        return this.rentalRate;
    }
    
    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    

    @Column(name="LENGTH")
    public Integer getLength() {
        return this.length;
    }
    
    public void setLength(Integer length) {
        this.length = length;
    }

    

    @Column(name="REPLACEMENT_COST", nullable=false, precision=5)
    public BigDecimal getReplacementCost() {
        return this.replacementCost;
    }
    
    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    

    @Column(name="RATING", length=5)
    public String getRating() {
        return this.rating;
    }
    
    public void setRating(String rating) {
        this.rating = rating;
    }

    

    @Column(name="SPECIAL_FEATURES", length=60)
    public String getSpecialFeatures() {
        return this.specialFeatures;
    }
    
    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="film")
    public Set<Inventory> getInventories() {
        return this.inventories;
    }
    
    public void setInventories(Set<Inventory> inventories) {
        this.inventories = inventories;
    }

@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="film")
    public Set<FilmActor> getFilmActors() {
        return this.filmActors;
    }
    
    public void setFilmActors(Set<FilmActor> filmActors) {
        this.filmActors = filmActors;
    }



public boolean equals(Object o) {
         if (this == o)
         return true;
		 if ( (o == null ) )
		 return false;
		 if ( !(o instanceof Film) )
		 return false;

		 Film that = ( Film ) o;

		 return ( (this.getFilmId()==that.getFilmId()) || ( this.getFilmId()!=null && that.getFilmId()!=null && this.getFilmId().equals(that.getFilmId()) ) );

   }

   public int hashCode() {
         int result = 17;

         result = 37 * result + ( getFilmId() == null ? 0 : this.getFilmId().hashCode() );

         return result;
     }


}

