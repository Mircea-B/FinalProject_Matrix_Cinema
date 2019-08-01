package sda.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sda.entity.Hall;

import java.util.List;

public interface HallRepository extends JpaRepository <Hall,Integer> {

    @Query(value = "select * from matrix_cinema.hall", nativeQuery = true)

    List<Hall> findAllByOrderByIdAsc();

    @Query(value = "select name,seat from matrix_cinema.hall order by seat", nativeQuery = true)

    List<Hall> findByNameOrderBySeatAsc(String name);



}
