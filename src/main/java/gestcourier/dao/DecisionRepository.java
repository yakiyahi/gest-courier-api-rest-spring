package gestcourier.dao;

import gestcourier.entities.Decision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DecisionRepository extends JpaRepository<Decision,Long> {
    @Query("select d from Decision d where d.idDecis=:x")
    public List<Decision> rechDecis(@Param("x")Long id);

}
