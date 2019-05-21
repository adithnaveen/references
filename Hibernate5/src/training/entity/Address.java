package training.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author imssbora
 */
@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
@ToString

public class Address {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ADDR_ID")
   private long id;

   @Column(name = "CITY")
   private String city;

   @Column(name = "STATE")
   private String state;

   @Column(name = "COUNTRY")
   private String country;

   @Column(name = "ZIP")
   private String zip;

   public Address() { }
   
   public Address(String city, String state, String country, String zip) {
      this.city = city;
      this.state = state;
      this.country = country;
      this.zip = zip;
   }
   // Setter and Getter methods
}