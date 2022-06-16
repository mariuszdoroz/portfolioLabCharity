package pl.coderslab.charity.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category() {}
}