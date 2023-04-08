package tn.esprit.picloundomicsgestionagriculteur.Services.ReclamationServices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation.Reclamation;
import tn.esprit.picloundomicsgestionagriculteur.Repository.ReclamationRepo.ReclamationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReclamationServiceImplementation implements IReclamation {

    ReclamationRepository reclamationRepository;

    @Override
    public Reclamation addReclamation(Reclamation reclamation){
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation updateReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation getReclamationById(Long Id) {
        return reclamationRepository.findById(Id).orElse(null);
    }

    @Override
    public List<Reclamation> getAllReclamation() {
        return reclamationRepository.findAll();
    }

    @Override
    public void deleteReclamation(Long Id) {
         reclamationRepository.deleteById(Id);

    }


}
