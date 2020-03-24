package test.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="geography")
public class Geography {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name ="id")
    private long id;

@Column(name = "City")
private String nameCity;

@Column(name="Description")
    private  String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Geography geography = (Geography) o;
        return id == geography.id &&
                Objects.equals(nameCity, geography.nameCity) &&
                Objects.equals(description, geography.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameCity, description);
    }
}
