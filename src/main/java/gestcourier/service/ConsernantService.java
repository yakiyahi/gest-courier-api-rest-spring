package gestcourier.service;
import gestcourier.dao.ConsernRepository;
import gestcourier.entities.Consernant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ConsernantService {
    @Autowired
    private ConsernRepository consRepo;

    //Listage des directions
    @RequestMapping(value = "/consernants",method = RequestMethod.GET)
    public List<Consernant> getConsernantAll(){
        return consRepo.findAll();
    }
    //Listage d une direction
    @RequestMapping(value = "/consernants/{matr}",method = RequestMethod.GET)
    public Consernant getConsernant(@PathVariable String matr){
        return consRepo.findById(matr).get();
    }

    //Ajout d une direction
    @RequestMapping(value = "/consernants",method = RequestMethod.POST)
    public Consernant saveConsernant(@RequestBody Consernant consernant){
        try {
            return consRepo.save(consernant);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    //Suppression d'une direction
    @RequestMapping(value = "/consernants/{matr}",method = RequestMethod.DELETE)
    public String  deleteConsernant(@PathVariable String matr){
        try{
            consRepo.deleteById(matr);
            return "SUCCESS";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "ERROR";
        }
    }
    //Modification des directions
    @RequestMapping(value = "/consernants",method = RequestMethod.PUT)
    public Consernant updateConsernant(@RequestBody Consernant consernant){
        Consernant cons = consRepo.findById(consernant.getCodeCons()).get();
        cons.setNomCons(consernant.getNomCons());
        cons.setPrenomCons(consernant.getPrenomCons());
        return consRepo.save(cons);
    }
    //Recherche d une direction
    @RequestMapping(value = "/rechConsernants/{motCle}",method = RequestMethod.GET)
    public List<Consernant> RechConsernant(@PathVariable String motCle){
        return consRepo.rechCons("%"+motCle+"%");
    }
    @RequestMapping(value = "/allNumsConsernants",method = RequestMethod.GET)
    public List<String> getAllNumsCons(){
        return consRepo.numsCons();
    }
}
