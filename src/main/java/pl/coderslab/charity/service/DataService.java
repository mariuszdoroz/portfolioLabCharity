package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.*;
import pl.coderslab.charity.repository.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@Service
public class DataService {

    private final CategoryRepository categoryRepository;
    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;


    public DataService(CategoryRepository categoryRepository, DonationRepository donationRepository, InstitutionRepository institutionRepository, RoleRepository roleRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public void loadData() {
        //role
        if(roleRepository.findAll().size() == 0) {
            roleRepository.saveAll(Arrays.asList(
               new Role("USER"),
               new Role("ADMIN")
            ));
        }
        //CategoryCreate
        if(categoryRepository.findAll().size() == 0) {
            categoryRepository.saveAll(Arrays.asList(
                    new Category("ubrania"),
                    new Category("zabawki")
            ));
        }
        if(institutionRepository.findAll().size() == 0) {
            institutionRepository.saveAll(Arrays.asList(
                    new Institution("Fundacja \"Dbam o Zdrowie\"","Cel i misja: Pomoc dzieciom z ubogich rodzin."),
                    new Institution("Fundacja \"A kogo\"", "Cel i misja: Pomoc wybudzaniu dzieci ze śpiączki."),
                    new Institution("Fundacja \"Dla dzieci\"", "Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej."),
                    new Institution("Fundacja \"Bez domu\"", "Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania.")
            ));
        }
        if(userRepository.findAll().size() == 0) {
            userRepository.saveAll(Arrays.asList(
                    //login: user@user.com / pass: 12345
                    new User("UserFirstName","UserLastName","user@user.com",
                            "$2a$12$hlg1KLbR/C9jwpLFsZL.nOkpAk0FyAS08vDEluWF.j8tLBrORpk0e",
                            roleRepository.findRoleByName("USER")),
                    //login: admin@admin.com / pass: 12345
                    new User("AdminFirstName","AdminLastName","admin@admin.com",
                            "$2a$12$hlg1KLbR/C9jwpLFsZL.nOkpAk0FyAS08vDEluWF.j8tLBrORpk0e",
                            roleRepository.findRoleByName("ADMIN"))
            ));
        }
        if(donationRepository.findAll().size() == 0) {
            donationRepository.saveAll(Arrays.asList(
                    new Donation(
                            1,
                            categoryRepository.findAll(),
                            institutionRepository.findAll().get(0),
                            "Mickiewicza 0",
                            "Katowice",
                            "40-092",
                            LocalDate.parse("2022-06-19"),
                            LocalTime.parse("18:00:00"),
                            "2nd floor",
                            userRepository.findAll().get(0)
                            )
            ));
        }
    }
}
