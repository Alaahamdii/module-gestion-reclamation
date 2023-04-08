package tn.esprit.picloundomicsgestionagriculteur.Services.ReclamationServices;

import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation.Reclamation;

import java.util.List;

public interface IReclamation {

    Reclamation addReclamation(Reclamation reclamation);
    Reclamation updateReclamation(Reclamation reclamation);
    Reclamation getReclamationById (Long Id);
    List <Reclamation> getAllReclamation ();
    void deleteReclamation(Long Id);


}
