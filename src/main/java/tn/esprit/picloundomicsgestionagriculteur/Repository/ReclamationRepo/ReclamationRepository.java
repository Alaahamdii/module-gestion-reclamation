package tn.esprit.picloundomicsgestionagriculteur.Repository.ReclamationRepo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation.Reclamation;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionUser.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

/////récupérer la liste de toutes les réclamations avec l'utilisateur associé à chaque réclamation, triées par ordre décroissant de date de réclamation.
    @Query("SELECT r FROM Reclamation r JOIN FETCH r.user ORDER BY r.dateRec DESC")
        List<Reclamation> findAllWithUserOrderByDateRecDesc();

///////récupérer toutes les réclamations d'un utilisateur spécifique triées par ordre décroissant de date de réclamation
    @Query("SELECT r FROM Reclamation r JOIN FETCH r.user u WHERE u.idUser = :userId ORDER BY r.dateRec DESC")
    List<Reclamation> findAllByUserIdWithUserOrderByDateRecDesc(@Param("userId") Long userId);


///////récupérer le nombre de réclamations pour chaque type de réclamation
    @Query("SELECT r.typeRec, COUNT(r) FROM Reclamation r GROUP BY r.typeRec")
    List<Object[]> countByTypeRec();

/////compter le nombre de réclamations pour chaque statut de réclamation
    @Query("SELECT r.statusRec, COUNT(r) FROM Reclamation r GROUP BY r.statusRec")
    List<Object[]> countByStatusRec();

    List<Reclamation> findReclamationsByUser(User user);

    @Modifying
    @Transactional
    @Query("UPDATE Reclamation r SET r.archived = true WHERE r.statusRec = 'resolu' AND r.dateRec <= :dateLimite")
    void archiveReclamations(@Param("dateLimite") Date dateLimite);

    @Query("SELECT r FROM Reclamation r JOIN FETCH r.user WHERE r.archived =true ")
    List<Reclamation> findByArchivedTrue();

    /// le type de reclamation le plus reclamé(statistique)
    @Query("SELECT r.typeRec, COUNT(r.idReclamation) FROM Reclamation r GROUP BY r.typeRec")
    List<Object[]> countReclamationsByTypeRec();
}
