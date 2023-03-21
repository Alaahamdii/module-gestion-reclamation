package tn.esprit.picloundomicsgestionagriculteur.Entities.GestionUser;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionTransformation.Pesticide;

import java.io.Serializable;
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
    @OneToMany
    private List<Pesticide> pesticides;}
