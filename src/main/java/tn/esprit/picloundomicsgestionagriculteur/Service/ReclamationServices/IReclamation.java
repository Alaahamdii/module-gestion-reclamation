package tn.esprit.picloundomicsgestionagriculteur.Service.ReclamationServices;

import org.springframework.http.ResponseEntity;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation.Reclamation;

import java.util.List;
import java.util.Optional;

public interface IReclamation {

     Reclamation addReclamation(Reclamation reclamation);
     ResponseEntity<?> updateReclamation(Reclamation reclamation, Long id);
     Optional<Reclamation> getReclamationById (Long Id);
   // static List<Reclamation> findReclamationByUser(Integer idUser);
     List<Reclamation> getReclamationsByUser (Integer idUser);
     List <Reclamation> getAllReclamation ();
     void deleteReclamation(Long Id);
     Reclamation addReclamationByUser(Reclamation reclamation, Integer id_user);
     Reclamation addReclamationParUser(Integer id , Reclamation reclamation);
     void archiveReclamationResolu();
     List<Reclamation> getByArchivedTrue();
}
