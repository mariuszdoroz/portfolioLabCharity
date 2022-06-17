package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.service.DonationService;

@Controller
public class FormController {

    private DonationService donationService;

    public FormController(DonationService donationService) {
        this.donationService = donationService;
    }

    @GetMapping("/donationform")
    public String registerForm(Model model){
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/donationform")
    public String registerForm(Donation donation) {
        donationService.save(donation);
        return "redirect:/";
    }
}
