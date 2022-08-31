package gestcourier.service;

import gestcourier.dao.DirectRepository;
import gestcourier.entities.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectionService {
    @Autowired
    private DirectRepository dirRepos;

    //Listage des directions
    @RequestMapping(value = "/directions",method = RequestMethod.GET)
    public List<Direction> getAllDirection(){
        return dirRepos.findAll();
    }
    //Ajout des directions
    @RequestMapping(value = "/directions",method = RequestMethod.POST)
    public Direction saveDirection(@RequestBody Direction direction){
        return dirRepos.save(direction);
    }
    //Modification des directions
    @RequestMapping(value = "/directions",method = RequestMethod.PUT)
    public Direction updateDirection(@RequestBody Direction direction){
        Direction direct = dirRepos.findById(direction.getCodeDirect()).get();
        direct.setDescrptDirect(direction.getDescrptDirect());
        direct.setAbrevDirect(direction.getAbrevDirect());
        //direct.setProvenance(direction.getProvenance());
        return dirRepos.save(direct);
    }
    //Suppression des directions
    @RequestMapping(value = "/directions/{codeDir}",method = RequestMethod.DELETE)
    public String deleteDirection(@PathVariable String codeDir){
        try{
            dirRepos.deleteById(codeDir);
            return "SUCCESS";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "ERROR";
        }
    }
    //Recherche d une direction
    @RequestMapping(value = "/rechDirections/{motCle}",method = RequestMethod.GET)
    public List<Direction> rechDirection(@PathVariable String motCle){
        return dirRepos.rechDirect("%"+motCle+"%");
    }
    @RequestMapping(value = "/allNumsDirections",method = RequestMethod.GET)
    public List<String> getAllNumsDirect(){
        return dirRepos.numsDirect();
    }
    @RequestMapping(value = "/directions/{codeDir}",method = RequestMethod.GET)
    public Direction getDrection(@PathVariable String codeDir){
        return dirRepos.findById(codeDir).get();
    }
}
