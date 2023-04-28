package tn.esprit.picloundomicsgestionagriculteur.Repository.UserRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.picloundomicsgestionagriculteur.Entities.GestionUser.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

 //User findByIdUser(Long idUser);

  List<User> findAll();

 Optional<User> findById(Integer id);
    @Query("SELECT u.email FROM User u")
    List<String> findAllEmails();

  //  List<String> findEmailsBySubscription(boolean b);
}
