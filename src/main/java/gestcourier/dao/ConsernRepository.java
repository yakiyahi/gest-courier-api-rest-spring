package gestcourier.dao;

import gestcourier.entities.Consernant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConsernRepository extends JpaRepository<Consernant,String> {
    @Query("select c from Consernant c where c.nomCons like :x OR c.prenomCons LIKE :x OR c.codeCons LIKE :x")
    public List<Consernant> rechCons(@Param("x")String motCle);
    @Query("select c.codeCons from Consernant c")
    public List<String> numsCons();
}
