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
@Table( name = "Produit")


public class Produit implements Serializable  {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)//auto increment
     private Integer idproduit;
    private String nomProduit;
    @Temporal(TemporalType.DATE)
    private Date dataCreation;
    private float prixProduit ;
    @Temporal(TemporalType.DATE)
    private Date dateValidite;
    private Boolean validite;
    @Enumerated(EnumType.STRING)
    private CategorieProduit categorieProduit;
    private float quantite;

   private  int qtitDechet;
    private int maxDechet;


}
