package gestcourier.service;

import gestcourier.dao.DecisionRepository;
import gestcourier.entities.Decision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
public class DecisionService {
    @Autowired
    private DecisionRepository decisRepos;

    //Listage des decisions
    @RequestMapping(value = "/decisions",method = RequestMethod.GET)
    public List<Decision> getDecisionAll(){
        return decisRepos.findAll();
    }
    //Listage d une decision
    @RequestMapping(value = "/decisions/{idDecis}",method = RequestMethod.GET)
    public Decision getDecision(@PathVariable Long idDecis){
        return decisRepos.findById(idDecis).get();
    }

    //Ajout d une decisions
    @RequestMapping(value = "/decisions",method = RequestMethod.POST)
    public Decision saveDecision(@RequestBody Decision decision){
        try {
            return decisRepos.save(decision);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    //Suppression d'une decisions
    @RequestMapping(value = "/decisions/{idDecis}",method = RequestMethod.DELETE)
    public String  deleteDecision(@PathVariable Long idDecis){
        try{
            decisRepos.deleteById(idDecis);
            return "SUCCESS";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "ERROR";
        }
    }
    //Modification des decisions
    @RequestMapping(value = "/decisions",method = RequestMethod.PUT)
    public Decision updateDecision(@RequestBody Decision decision){
        Decision decis= decisRepos.findById(decision.getIdDecis()).get();
        decis.setTypeDecis(decision.getTypeDecis());
        decis.setDescrDcis(decision.getDescrDcis());
        decis.setDateDecis(decision.getDateDecis());
        return decisRepos.save(decis);
    }
    //Recherche d une direction
    @RequestMapping(value = "/rechDecisions/{id}",method = RequestMethod.GET)
    public List<Decision> RechDecision(@PathVariable Long id){
        return decisRepos.rechDecis(id);
    }

}
