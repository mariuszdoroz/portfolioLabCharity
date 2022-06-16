package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.DataService;


@Controller
public class HomeController {

    private DataService dataService;

    public HomeController(DataService dataService) {
        this.dataService = dataService;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        return "index";
    }

    @GetMapping("/loaddata")
    public String data(){
        dataService.loadData();
        return "redirect:/login";
    }
}
