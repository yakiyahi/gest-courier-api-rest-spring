package gestcourier.service;

import gestcourier.dao.CourierRepository;
import gestcourier.entities.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourierService {
    @Autowired
    private CourierRepository courRepos;

    @RequestMapping(value = "/couriers",method = RequestMethod.GET)
    public List<Courier> getCouriers(){
        return courRepos.findAll();
    }
    @RequestMapping(value = "/couriers",method = RequestMethod.POST)
    public Courier saveCourier(@RequestBody Courier courier){
        return courRepos.save(courier);
    }
    @RequestMapping(value = "/couriers/{refCour}",method = RequestMethod.GET)
    public Courier getCourier(@PathVariable String refCour){
        return courRepos.findById(refCour).get();
    }
    @RequestMapping(value = "/couriers/{refCour}",method = RequestMethod.DELETE)
    public String deleteCourier(@PathVariable String refCour){
        try{
            courRepos.deleteById(refCour);
            return "SUCCESS";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "ERROR";
        }
    }
    @RequestMapping(value = "/couriers",method = RequestMethod.PUT)
    public Courier updateCourier(@RequestBody Courier courier){
        Courier cour =courRepos.findById(courier.getRefCour()).get();
        cour.setTypeCour(courier.getTypeCour());
        cour.setDescrCour(courier.getDescrCour());

        return courRepos.save(cour);
    }
    @RequestMapping(value = "/rechCourier/{motCle}",method = RequestMethod.GET)
    public List<Courier> rechCourier(@PathVariable String motCle){
        return  courRepos.rechCour("%"+motCle+"%");
    }
    @RequestMapping(value = "/allRefCours",method = RequestMethod.GET)
    public List<String> rechCourier(){
        return  courRepos.numsCouriers();
    }

    @RequestMapping(value = "/graph",method = RequestMethod.GET)
    public List<String> setGraph(){

        return courRepos.graph();
    }
}
