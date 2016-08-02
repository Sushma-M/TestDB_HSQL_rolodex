/*Generated by WaveMaker Studio*/

package com.testdb_hsql.rolodex;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
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
 * Country generated by hbm2java
 */
@Entity
@Table(name="COUNTRY"
    ,schema="PUBLIC"
)
public class Country  implements java.io.Serializable
 {


private Integer countryId;
private String country;
private Set<City> cities = new HashSet<City>(0);

    public Country() {
    }



     @Id @GeneratedValue(strategy=IDENTITY)

    

    @Column(name="COUNTRY_ID", nullable=false)
    public Integer getCountryId() {
        return this.countryId;
    }
    
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    

    @Column(name="COUNTRY", nullable=false, length=50)
    public String getCountry() {
        return this.country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }

@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="country")
    public Set<City> getCities() {
        return this.cities;
    }
    
    public void setCities(Set<City> cities) {
        this.cities = cities;
    }



public boolean equals(Object o) {
         if (this == o)
         return true;
		 if ( (o == null ) )
		 return false;
		 if ( !(o instanceof Country) )
		 return false;

		 Country that = ( Country ) o;

		 return ( (this.getCountryId()==that.getCountryId()) || ( this.getCountryId()!=null && that.getCountryId()!=null && this.getCountryId().equals(that.getCountryId()) ) );

   }

   public int hashCode() {
         int result = 17;

         result = 37 * result + ( getCountryId() == null ? 0 : this.getCountryId().hashCode() );

         return result;
     }


}

