package tn.esprit.picloundomicsgestionagriculteur.Service.userService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionUser.User;
import tn.esprit.picloundomicsgestionagriculteur.Repository.UserRepo.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements IUser {



    private UserRepository userRepository;


    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
}

