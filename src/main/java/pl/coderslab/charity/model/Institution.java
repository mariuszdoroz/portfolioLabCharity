package pl.coderslab.charity.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    public Institution(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Institution() {}
}
