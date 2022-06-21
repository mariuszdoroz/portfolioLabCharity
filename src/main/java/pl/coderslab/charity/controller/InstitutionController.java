package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.InstitutionService;

@Controller
public class InstitutionController {

    private InstitutionService institutionService;


    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/institution")
    public String institutionList(Model model) {
        model.addAttribute("institution", new Institution());
        model.addAttribute("institutionlist", institutionService.findAll());
        return "institution";
    }

    @PostMapping("/institution")
    public String institutionAdd(Model model, Institution institution) {
        institutionService.save(institution);
        return "redirect:/institution";
    }

    @GetMapping("/institution/del/{id}")
    public String institutionDel(Model model, @PathVariable Long id) {
        institutionService.delete(id);
        return "redirect:/institution";
    }

    @GetMapping("/institution/{id}")
    public String institutionEdit(Model model, @PathVariable Long id) {
        model.addAttribute("institution", institutionService.getById(id));
        return "institution";
    }
}
