package gestcourier.service;

import gestcourier.dao.ProvenanceRepository;
import gestcourier.entities.Provenance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProvenanceService {
    @Autowired
    private ProvenanceRepository provRepos;

    @RequestMapping(value = "/provenances",method = RequestMethod.GET)
    public List<Provenance> getProvenances(){
        return provRepos.findAll();
    }
    @RequestMapping(value = "/provenances/{codeProv}",method = RequestMethod.GET)
    public Provenance getProvenance(@PathVariable String codeProv){
        return provRepos.findById(codeProv).get();
    }
    @RequestMapping(value = "/provenances/{codeProv}",method = RequestMethod.DELETE)
    public String deleteProvenances(@PathVariable String codeProv){
        try{
            provRepos.deleteById(codeProv);
            return "SUCCESS";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "ERROR";
        }
    }
    //Modification des provenances
    @RequestMapping(value = "/provenances",method = RequestMethod.PUT)
    public Provenance updateProvenances(@RequestBody Provenance provenance){
        Provenance prov =provRepos.findById(provenance.getCodeProv()).get();
        prov.setAbrevProv(provenance.getAbrevProv());
        prov.setLibelProv(provenance.getLibelProv());

        return provRepos.save(prov);
    }
    @RequestMapping(value = "/provenances",method = RequestMethod.POST)
    public Provenance saveProvenances(@RequestBody Provenance provenance){

        return provRepos.save(provenance);
    }
    @RequestMapping(value = "/allNumsPovenances",method = RequestMethod.GET)
    public List<String> getAllNumsProv(){
        return provRepos.numsProvs();
    }
    @RequestMapping(value = "/rechProvenances/{motCle}",method = RequestMethod.GET)
    public List<Provenance> rechProvenances(@PathVariable String motCle){
        return provRepos.rechProv("%"+motCle+"%");
    }
}
