package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.DataService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;


@Controller
public class HomeController {

    private DataService dataService;
    private InstitutionService institutionService;
    private DonationService donationService;

    public HomeController(DataService dataService, InstitutionService institutionService, DonationService donationService) {
        this.dataService = dataService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutionlist", institutionService.findAll());
        model.addAttribute("countbags", donationService.countBags());
        model.addAttribute("countdonations", donationService.countDonations());
        return "index";
    }

    @GetMapping("/loaddata")
    public String data(){
        dataService.loadData();
        return "redirect:/login";
    }
}
