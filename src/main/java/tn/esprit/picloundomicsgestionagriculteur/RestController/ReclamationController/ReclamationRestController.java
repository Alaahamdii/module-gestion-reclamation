package tn.esprit.picloundomicsgestionagriculteur.RestController.ReclamationController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation.Reclamation;
import tn.esprit.picloundomicsgestionagriculteur.Services.ReclamationServices.IReclamation;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
//@RequestMapping("/reclamation")
public class ReclamationRestController {
    @Autowired
    IReclamation iReclamation;

    @GetMapping("/getAllRec")
    public List<Reclamation> getAllReclamation(){

        return iReclamation.getAllReclamation();
    }


    @GetMapping("/getRecById/{id}")
    public Reclamation getReclamationById (@PathVariable("id") Long id){
        return iReclamation.getReclamationById(id);}

    @PostMapping("/addReclamation")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation){
        return iReclamation.addReclamation(reclamation);
    }

    @PutMapping("/updateReclamation")
    public Reclamation updateReclamation (@RequestBody Reclamation reclamation){
      return  iReclamation.updateReclamation(reclamation);
    }





    @DeleteMapping("/delReclamation/{id}")
    public void deleteReclamation(@PathVariable("id") Long id){
         iReclamation.deleteReclamation(id);
    }

}
