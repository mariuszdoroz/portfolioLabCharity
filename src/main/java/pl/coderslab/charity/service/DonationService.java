package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationService {

    public final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public void save(Donation donation) {
        donationRepository.save(donation);
    }

    public Integer countBags() {
        return donationRepository.sumQuantity();
    }
    public Integer countDonations() {
        return donationRepository.sumDonations();
    }

}
