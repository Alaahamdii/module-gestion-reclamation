package tn.esprit.picloundomicsgestionagriculteur.Entities.GestionLivraison;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionAgriculteur.CouleurSol;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionProduit.StatusPaiement;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table( name = "Livraison")
public class Livraison  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLivraison;

    private float  prixLivraison;
    private int numeroRegionDest;
    @Temporal(TemporalType.DATE)
    private Date dateLivraison;
    private StatusPaiement statusPaiement;

}
