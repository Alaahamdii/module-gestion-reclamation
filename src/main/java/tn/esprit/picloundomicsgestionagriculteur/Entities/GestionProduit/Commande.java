package tn.esprit.picloundomicsgestionagriculteur.Entities.GestionProduit;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table( name = "Commande")

public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
    private Integer idCommand;
    @Temporal(TemporalType.DATE)
    private Date dateCommande;
    @Enumerated(EnumType.STRING)
    private StatusCommande statusCommande;
    @Enumerated(EnumType.STRING)
    private StatusPaiement statusPaiement;


}
