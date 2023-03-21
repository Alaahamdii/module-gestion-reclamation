package tn.esprit.picloundomicsgestionagriculteur.Entities.GestionAgriculteur;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionProduit.CategorieProduit;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionProduit.Produit;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table( name = "Terrin")
public class Terrin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
    private Integer idTerrin;
    private float surface;
    @Enumerated(EnumType.STRING)
    private SaisonRecolte saisonRecolte;
    private float EauCourante;
    @OneToOne
    @JoinColumn(name = "sol_id")
    private TypeSol sol;
    private int FrequenceArrosage;

    @ManyToOne
    @JoinColumn(name = "produit_idproduit")
    private Produit produit;

    @Temporal(TemporalType.DATE)
    private Date dateObtentionTerrin;
}
