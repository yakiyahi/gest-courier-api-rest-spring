package gestcourier.dao;

import gestcourier.entities.Arrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ArriveRepository extends JpaRepository<Arrive,Long> {
    @Query("select a from Arrive a where a.idArive =:x")
    public List<Arrive> rechArrive(@Param("x") Long idarv);
    @Query("select a.idArive from Arrive a")
    public List<String> numsArrivee();
}
