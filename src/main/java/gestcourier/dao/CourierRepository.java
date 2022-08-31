package gestcourier.dao;

import gestcourier.entities.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourierRepository extends JpaRepository<Courier,String> {
    @Query("select c from Courier c where c.refCour like :x ")
    public List<Courier> rechCour(@Param("x") String motCle);
    @Query("select c.refCour from Courier c")
    public List<String> numsCouriers();

    @Query("select  c.direction.provenance.abrevProv, count(c.refCour) as refCour from Courier c GROUP BY c.direction.provenance.abrevProv")
    public List<String> graph();
}
