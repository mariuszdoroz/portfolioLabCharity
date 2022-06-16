package pl.coderslab.charity.model;

import javax.persistence.*;

@Entity
@Table
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

}
