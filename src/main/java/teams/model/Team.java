package teams.model;

import javax.persistence.*;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 *
 */
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer rating;

    public Team() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public String toString(){
        return "id="+id+", name="+name+", rating="+rating;
    }
}
