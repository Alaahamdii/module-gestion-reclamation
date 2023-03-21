package tn.esprit.picloundomicsgestionagriculteur.Entities.GestionAgriculteur;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionProduit.CategorieProduit;

import java.io.Serializable;

@AllArgsConstructor
@Entity
@Getter
@Setter
@NoArgsConstructor
public class TypeSol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSol;
    private String nomSol;
    @Enumerated(EnumType.STRING)
    private CouleurSol couleurSol;
    @Enumerated(EnumType.STRING)
    private TextureSol textureSol;

    private float tauxMCarre;
    private float tauxadequat;


}
