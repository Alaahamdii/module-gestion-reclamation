package tn.esprit.picloundomicsgestionagriculteur.Service.userService;

import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionUser.User;

import java.util.Optional;

public interface IUser {

    public Optional<User> getUserById(Integer id);
}
