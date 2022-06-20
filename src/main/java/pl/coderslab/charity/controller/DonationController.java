package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.security.Principal;

@Controller
public class DonationController {

    private DonationService donationService;
    private InstitutionService institutionService;
    private CategoryService categoryService;


    public DonationController(DonationService donationService, InstitutionService institutionService, CategoryService categoryService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.categoryService = categoryService;
    }

    @GetMapping("/donationform")
    public String registerForm(Model model){
        model.addAttribute("donation", new Donation());
        model.addAttribute("institutionlist", institutionService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "form";
    }

    @PostMapping("/donationform")
    public String registerForm(Donation donation, Principal principal) {
        donationService.save(donation, principal);
        return "form-confirmation";
    }
}
