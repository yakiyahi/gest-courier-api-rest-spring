package gestcourier.dao;

import gestcourier.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,String> {
    @Query("select u from Utilisateur u where u.userPseudo =:x AND u.userPassword =:y ")
    public Utilisateur login(@Param("x") String userPseudo,@Param("y") String userPassword);

    @Query("select u.userNum from Utilisateur u")
    public List<String> numsUtilisateur();

    @Query("select u from Utilisateur u where u.userNum like :x OR u.userName LIKE :x OR u.userPseudo LIKE :x")
    public List<Utilisateur> searchUser(@Param("x")String motCle);

}
