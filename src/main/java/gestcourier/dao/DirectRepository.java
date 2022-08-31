package gestcourier.dao;

import gestcourier.entities.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DirectRepository extends JpaRepository<Direction,String>{
        @Query("select d from Direction d where d.descrptDirect like :x OR d.codeDirect LIKE :x OR d.abrevDirect LIKE :x")
        public List<Direction> rechDirect(@Param("x") String motCle);
        @Query("select d.codeDirect from Direction d")
        public List<String> numsDirect();
}
