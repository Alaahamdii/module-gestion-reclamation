package tn.esprit.picloundomicsgestionagriculteur.Entities.GestionUser;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionAgriculteur.Terrin;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionLivraison.Livraison;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionProduit.Commande;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionProduit.Produit;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation.Reclamation;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionTransformation.Equipe;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionTransformation.Pesticide;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table( name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String username;

    private String password;
    private int numTel;

    @Email
    private String email;

    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Pesticide> pesticides ;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Equipe> equipes ;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Livraison> livraisons ;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Reclamation> reclamations ;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Terrin> terrins ;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Produit> produits ;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<Commande> commandes ;

}

