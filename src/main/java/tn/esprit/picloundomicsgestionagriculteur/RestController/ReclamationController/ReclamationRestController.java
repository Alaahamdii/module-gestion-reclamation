package tn.esprit.picloundomicsgestionagriculteur.RestController.ReclamationController;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation.Reclamation;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation.statusRecl;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation.typeRecl;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionUser.User;
import tn.esprit.picloundomicsgestionagriculteur.Service.ReclamationServices.IReclamation;
import tn.esprit.picloundomicsgestionagriculteur.Service.ReclamationServices.ReclamationServiceImplementation;
import tn.esprit.picloundomicsgestionagriculteur.Service.userService.IUser;
import tn.esprit.picloundomicsgestionagriculteur.Service.userService.UserService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1/")
public class ReclamationRestController {
    @Autowired
    IReclamation iReclamation;
    @Autowired
    ReclamationServiceImplementation reclamationService;
    @Autowired
    UserService userService;
    @Autowired
    IUser iUser;


    @GetMapping("/getAllRec")
    public List<Reclamation> getAllReclamation(){

        return iReclamation.getAllReclamation();
    }


    @GetMapping("/getRecById/{id}")
    public Reclamation getReclamationById (@PathVariable("id") Long id){
        return reclamationService.getReclamationById(id).orElseThrow
                (
                        ()->new EntityNotFoundException("Requested task not found")
                );
    }


    @GetMapping("/reclamation/{userId}")
    public  List<Reclamation> getReclamationByUser(@PathVariable("userId") Integer userId){

        return iReclamation.getReclamationsByUser(userId);  /*.orElseThrow
                        (
                                ()->new EntityNotFoundException("Requested task not found")
                        );  */
    }



    @PostMapping("/addReclamation")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation){
        return iReclamation.addReclamation(reclamation);
    }






    @PutMapping("/updateReclamation/{id}")
    public ResponseEntity<?> updateReclamation (@RequestBody Reclamation reclamation, @PathVariable Long id) {
        ResponseEntity<?> updated = iReclamation.updateReclamation(reclamation, id);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();



    }




    @DeleteMapping("/delReclamation/{id}")
    public ResponseEntity<?> deleteReclamation(@PathVariable("id") Long id){

        HashMap<String,String> message =new HashMap<>();
        if (reclamationService.existById(id)){
            iReclamation.deleteReclamation(id);
            message.put("message ","Reclamation with id "+id+" deleted successfully");
            return ResponseEntity.status(HttpStatus.OK).body(message);
        }
        else
        {
            message.put("message "," Reclamation with id "+id+" not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

    }


    @GetMapping("/all-with-user")
    public List<Reclamation> getAllReclamationsWithUser() {
        return reclamationService.findAllWithUserOrderByDateRecDesc();
    }


    @GetMapping("/by-user/{userId}")
    public List<Reclamation> getAllReclamationsByUserIdWithUser(@PathVariable ("userId") Long userId) {
        return reclamationService.findAllByUserIdWithUserOrderByDateRecDesc(userId);
    }


    @GetMapping("/count-by-type-rec")
    public List<Object[]> countByTypeRec() {
        return reclamationService.countByTypeRec();

    }

    @GetMapping("/count-by-status")
    public List<Object[]> countReclamationsByStatus() {
        return reclamationService.countReclamationsByStatus();
    }

    @PostMapping("/addreclamationbyuser/{id}")
    public ResponseEntity<Reclamation> addReclamationByUser(@PathVariable("id") Integer userId,
                                                     @RequestBody Reclamation reclamation) {
        Reclamation savedrecl = iReclamation.addReclamationByUser(reclamation, userId);
        return ResponseEntity.ok(savedrecl);

    }

    @PostMapping("/addById/{userId}")
    public ResponseEntity<Reclamation> addReclamationParUser(@PathVariable("userId") Integer userId, @RequestBody Reclamation reclamation) {
        Optional<User> user = iUser.getUserById(userId);
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        reclamation.setDateRec(new Date());
        reclamation.setStatusRec(statusRecl.INITIALE);
        Reclamation createdReclamation = iReclamation.addReclamationParUser(userId, reclamation);
        return ResponseEntity.ok(createdReclamation);
    }

    @PutMapping("/archiverReclamationResolu")
    public void archiveReclamationResolu(){
        iReclamation.archiveReclamationResolu();
    }

    @GetMapping("/archive")
    List<Reclamation> getByArchivedTrue(){
        return  iReclamation.getByArchivedTrue();

    }

    @GetMapping("/type-reclamations/statistics")
    public ResponseEntity<typeRecl> getTypeReclamationLePlusReclame() {
        typeRecl typeReclMax = reclamationService.getTypeReclamationLePlusReclame();
        return ResponseEntity.ok().body(typeReclMax);
    }

}
