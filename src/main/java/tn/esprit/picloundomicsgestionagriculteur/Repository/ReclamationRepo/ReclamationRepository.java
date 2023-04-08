package tn.esprit.picloundomicsgestionagriculteur.Repository.ReclamationRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
}
