package tn.esprit.picloundomicsgestionagriculteur.Service.ReclamationServices;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation.Reclamation;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation.typeRecl;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionUser.User;
import tn.esprit.picloundomicsgestionagriculteur.Repository.ReclamationRepo.ReclamationRepository;
import tn.esprit.picloundomicsgestionagriculteur.Repository.UserRepo.UserRepository;

import java.util.*;

@Service
@AllArgsConstructor
public class ReclamationServiceImplementation implements IReclamation {

    ReclamationRepository reclamationRepository;
    UserRepository userRepository;


    @Override
    public List<Reclamation> getAllReclamation() {
        return reclamationRepository.findAll();
    }


    @Override
    public Optional<Reclamation> getReclamationById(Long Id) {
        return reclamationRepository.findById(Id);
    }

    @Override
    public Reclamation addReclamation(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }


    @Override
    public List<Reclamation> getReclamationsByUser(Integer userid) {
        User user = userRepository.findById(userid)
                .orElseThrow(() -> new IllegalArgumentException("invalid user id"));
        return reclamationRepository.findReclamationsByUser(user);
    }



    @Override
    public ResponseEntity<?> updateReclamation(Reclamation reclamation, Long id) {
        Reclamation reclamation1 = reclamationRepository.findById(id).orElse(null);
        if (reclamation1 != null) {
            reclamation1.setDateRec(reclamation.getDateRec());
            reclamation1.setStatusRec(reclamation.getStatusRec());
            reclamation1.setDatResolution(reclamation.getDatResolution());
            reclamation1.setTypeRec(reclamation.getTypeRec());
            reclamation1.setDescription(reclamation.getDescription());
            //reclamation1.setUser(reclamation.getUser());
            reclamationRepository.save(reclamation1);
            return ResponseEntity.ok().body(reclamation1);
            // return reclamationRepository.save(reclamation1);
            }
            else {
            HashMap<String, String> message = new HashMap<>();
            message.put("reclamation id =  " + id, " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);}

    }


    @Override
    public void deleteReclamation(Long Id) {
         reclamationRepository.deleteById(Id);
    }


    public List<Reclamation> findAllWithUserOrderByDateRecDesc() {
        return reclamationRepository.findAllWithUserOrderByDateRecDesc();
    }

    public List<Reclamation> findAllByUserIdWithUserOrderByDateRecDesc(Long userId) {
        return reclamationRepository.findAllByUserIdWithUserOrderByDateRecDesc(userId);
    }


    public List<Object[]> countByTypeRec() {
        return reclamationRepository.countByTypeRec();
    }

    public List<Object[]> countReclamationsByStatus(){
        return reclamationRepository.countByStatusRec();
    }


    /*public List<ReclamationCountDto> countReclamationsByStatus() {
        List<Object[]> results = reclamationRepository.countByStatusRec();
        List<ReclamationCountDto> counts = new ArrayList<>();
        for (Object[] result : results) {
            String status = (String) result[0];
            Long count = (Long) result[1];
            counts.add(new ReclamationCountDto(status, count));}
        return counts;}*/

    /*public Reclamation addReclamationParUser(Integer userId, Reclamation reclamation) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            reclamation.setUser(user.get());
            return reclamationRepository.save(reclamation);
        } else {
            throw new EntityNotFoundException("User not found with id: " + userId);
        }
    }*/

    public Reclamation addReclamationParUser(Integer userId, Reclamation reclamation) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        reclamation.setUser(user);
        return reclamationRepository.save(reclamation);
    }


     public Reclamation addReclamationByUser(Reclamation reclamation, Integer id_user) {
        User user = userRepository.findById(id_user)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id_user));
        reclamation.setUser(user);
        return reclamationRepository.save(reclamation);

    }

    public boolean existById(Long id) {
        return reclamationRepository.existsById(id);
    }



    @Scheduled(cron = "0 8 0 * * *")
    public void archiveReclamationResolu() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date dateLimite = cal.getTime();
        reclamationRepository.archiveReclamations(dateLimite);
    }

    public List<Reclamation> getByArchivedTrue(){
        return reclamationRepository.findByArchivedTrue();
    }

    public typeRecl getTypeReclamationLePlusReclame() {
        List<Object[]> results = reclamationRepository.countReclamationsByTypeRec();
        typeRecl typeReclMax = null;
        long maxCount = 0;

        for (Object[] result : results) {
            long count = (long) result[1];
            if (count > maxCount) {
                typeReclMax = (typeRecl) result[0];
                maxCount = count;
            }
        }

        return typeReclMax;
    }
}