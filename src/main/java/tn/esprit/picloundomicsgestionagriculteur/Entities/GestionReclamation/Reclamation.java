package tn.esprit.picloundomicsgestionagriculteur.Entities.GestionReclamation;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionUser.User;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table( name = "Reclamation")
public class Reclamation  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamation;

    private String description;
    @Temporal(TemporalType.DATE)
    private Date dateRec;
    @Temporal(TemporalType.DATE)
    private Date datResolution;
    @Enumerated(EnumType.STRING)
    private typeRecl typeRec;
    @Enumerated(EnumType.STRING)
    private statusRecl statusRec;

    private Boolean archived = false;

    //
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id_user")
    private User user;

}
