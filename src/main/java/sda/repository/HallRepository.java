package sda.repository;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sda.entity.Hall;

import java.util.List;

public interface HallRepository extends JpaRepository <Hall,Integer> {

    List<Hall> findAllByOrderByIdAsc();

//TODO Find a better way to sort this out
    @Query(value = "select name,seat from matrix_cinema.hall order by seat", nativeQuery = true)
    List<Hall> findByNameOrderBySeatAsc(String name);

}
