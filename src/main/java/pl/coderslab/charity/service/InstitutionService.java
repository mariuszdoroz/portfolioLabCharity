package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    public void save(Institution institution) {
        institutionRepository.save(institution);
    }

    public void delete(Long id) {
        institutionRepository.delete(institutionRepository.getById(id));
    }

    public Institution getById(Long id) {
        return institutionRepository.getById(id);
    }
}
