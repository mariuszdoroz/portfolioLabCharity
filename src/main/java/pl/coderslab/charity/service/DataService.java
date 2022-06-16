package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.*;

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
        //role: user
        Role role1 = new Role();
        role1.setName("USER");
        roleRepository.save(role1);
        //role: admin
        Role role2 = new Role();
        role2.setName("ADMIN");
        roleRepository.save(role2);
        //username: user
        //pass: 12345
        User user = new User();
        user.setUsername("user@user.com");
        user.setPassword("$2a$12$hlg1KLbR/C9jwpLFsZL.nOkpAk0FyAS08vDEluWF.j8tLBrORpk0e");
        user.setRole(roleRepository.findRoleByName("USER"));
        userRepository.save(user);
        //username: admin
        //pass: 12345
        User admin = new User();
        admin.setUsername("admin@admin.com");
        admin.setPassword("$2a$12$hlg1KLbR/C9jwpLFsZL.nOkpAk0FyAS08vDEluWF.j8tLBrORpk0e");
        admin.setRole(roleRepository.findRoleByName("ADMIN"));
        userRepository.save(admin);
    }
}
