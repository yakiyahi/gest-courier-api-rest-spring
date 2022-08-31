package gestcourier.service;

import gestcourier.dao.ArriveRepository;
import gestcourier.entities.Arrive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class ArriveService {
    @Autowired
    private ArriveRepository arrivRepos;

    @RequestMapping(value = "/arrivées",method = RequestMethod.GET)
    public List<Arrive> getAllArrive(){
        return arrivRepos.findAll();
    }
    @RequestMapping(value = "/arrivées/{idArive}",method = RequestMethod.GET)
    public Arrive getArrive(@PathVariable Long idArive){
        return arrivRepos.findById(idArive).get();
    }
    @RequestMapping(value = "/arrivées/{idArive}",method = RequestMethod.DELETE)
    public String deleteArrive(@PathVariable Long idArive ){
        try{
            arrivRepos.deleteById(idArive);
            return "SUCCESS";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "ERROR";
        }
    }
    @RequestMapping(value = "/arrivées",method = RequestMethod.POST)
    public Arrive saveArrive(@RequestBody Arrive arrive){
        arrivRepos.save(arrive);
        return arrive;
    }
    @RequestMapping(value = "/arrivées",method = RequestMethod.PUT)
    public Arrive updateArrive(@RequestBody Arrive arrive){
        Arrive arv =arrivRepos.findById(arrive.getIdArive()).get();
        arv.setHeurArive(arrive.getHeurArive());
        arv.setDateArive(arrive.getDateArive());
        return arrivRepos.save(arv);
    }

    @RequestMapping(value = "/rechArrivées/{idArv}",method = RequestMethod.GET)
    public List<Arrive> rechArr(@PathVariable Long idArv){
        return arrivRepos.rechArrive(idArv);
    }
    @RequestMapping(value = "/allIdArrivées",method = RequestMethod.GET)
    public List<String> getAllIdArrivee(){
        return arrivRepos.numsArrivee();
    }
}
