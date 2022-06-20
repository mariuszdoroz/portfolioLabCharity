package pl.coderslab.charity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;

    @OneToMany
    private List<Category> categories = new ArrayList<>();

    @OneToOne
    private Institution institution;
    private String street;
    private String city;
    private String zipCode;
    private String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;
    private String pickUpComment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Donation(Integer quantity, List<Category> categories, Institution institution, String street, String city, String zipCode, String phone, LocalDate pickUpDate, LocalTime pickUpTime, String pickUpComment, User user) {
        this.quantity = quantity;
        this.categories = categories;
        this.institution = institution;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.phone = phone;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
        this.user = user;
    }

    public Donation() {}
}
