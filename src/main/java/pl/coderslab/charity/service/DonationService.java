package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.security.Principal;

@Service
public class DonationService {

    public final DonationRepository donationRepository;
    public final UserRepository userRepository;

    public DonationService(DonationRepository donationRepository, UserRepository userRepository) {
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
    }

    public void save(Donation donation, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        donation.setUser(user);
        donationRepository.save(donation);
    }

    public Integer countBags() {
        return donationRepository.sumQuantity();
    }
    public Integer countDonations() {
        return donationRepository.sumDonations();
    }

}
