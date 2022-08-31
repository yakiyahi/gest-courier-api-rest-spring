package gestcourier.service;

import gestcourier.dao.UtilisateurRepository;
import gestcourier.entities.Login;
import gestcourier.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository userRepos;

    @RequestMapping(value = "/utilisateurs",method = RequestMethod.GET)
    public List<Utilisateur> getAllUtilisateur(){
        return userRepos.findAll();
    }
    @RequestMapping(value = "/utilisateurs",method = RequestMethod.POST)
    public Utilisateur saveUtililisateur(@RequestBody Utilisateur utilisateur){
        return userRepos.save(utilisateur);
    }

    @RequestMapping(value = "/utilisateurs/{userNum}",method = RequestMethod.DELETE)
    public String deleteUtililisateur(@PathVariable String userNum){
        try{
            userRepos.deleteById(userNum);
            return "SUCCESS";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "ERROR";
        }
    }
    @RequestMapping(value = "/utilisateurs",method = RequestMethod.PUT)
    public Utilisateur updateUtililisateur(@RequestBody Utilisateur utilisateur){
        Utilisateur user = userRepos.findById(utilisateur.getUserNum()).get();
        user.setUserName(utilisateur.getUserName());
        user.setUserPseudo(utilisateur.getUserPseudo());
        user.setUserRule(utilisateur.getUserRule());
        return userRepos.save(user);
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Utilisateur login(@RequestBody Login login){
        Utilisateur user= userRepos.login(login.getPseudo(),login.getPassword());
        return user;
    }
    @RequestMapping(value = "/allIdUtilisateur",method = RequestMethod.GET)
    public List<String> getAllIdUtilisateur(){
        return userRepos.numsUtilisateur();
    }
    @RequestMapping(value = "/utilisateurs/{userNum}",method = RequestMethod.GET)
    public Utilisateur getUtilisateur(@PathVariable String userNum){
        return userRepos.findById(userNum).get();
    }
    @RequestMapping(value = "/rechUtilisateurs/{motCle}",method = RequestMethod.GET)
    public List<Utilisateur> rechUtilisateur(@PathVariable String motCle){
        return userRepos.searchUser("%"+motCle+"%");
    }
}
