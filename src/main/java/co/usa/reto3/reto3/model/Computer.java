package co.usa.reto3.reto3.model;

/**
 *
 * @author sergio
 */

/**
 *
 * Imports 
 */
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * tabla
 */
@Entity
@Table(name = "computer")
public class Computer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     *  id 
     */
    private Integer id;
    /**
     *  name 
     */
    private String name;
    /**
     *  brand 
     */
    private String brand;
    /**
     * year 
     */
    private Integer year;
    /**
     *  description 
     */
    private String description;


    /**
     * relacion muchos a uno 
     */
    @ManyToOne
    @JoinColumn(name = "category")
    @JsonIgnoreProperties("computers")
    private Category category;

    /**
     * relacion uno a muchos 
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "computer") 
    @JsonIgnoreProperties({"computer","client"})
    private List<Message> messages;

    /**
     * relacion uno a muchos
    */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "computer") 
    @JsonIgnoreProperties({"computer","client"})
    private List<Reservation> reservations;


    /**
     * Get atributo ID
    */
    public Integer getId() {
        return id;
    }

    /**
     * Set atributo ID
    */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get atributo Name
    */
    public String getName() {
        return name;
    }

    /**
     * Set atributo Name
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get atributo Brand
    */
    public String getBrand() {
        return brand;
    }

    /**
     * Set atributo Brand
    */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Get atributo Year
    */
    public Integer getYear() {
        return year;
    }

    /**
     * Get atributo Year
    */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Get atributo Description
    */
    public String getDescription() {
        return description;
    }

    /**
     * Set atributo Description
    */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get atributo Category
    */
    public Category getCategory() {
        return category;
    }

    /**
     * set atributo Category
    */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Get atributo Messages
    */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Set atributo Category
    */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Get atributo Reservations
    */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Set atributo Reservations
    */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    

   
    
}
