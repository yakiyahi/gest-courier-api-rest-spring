package gestcourier.dao;

import gestcourier.entities.Provenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProvenanceRepository extends JpaRepository<Provenance,String> {

    @Query("select p.codeProv from Provenance p")
    public List<String> numsProvs();

    @Query("select p from Provenance p where p.codeProv like :x OR  p.abrevProv LIKE :x")
    public List<Provenance> rechProv(@Param("x") String motCle);
}
