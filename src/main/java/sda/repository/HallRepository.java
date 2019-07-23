package sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.entity.Hall;

import java.util.List;

public interface HallRepository extends JpaRepository <Hall,Integer> {

    List<Hall> findAllByOrderByIdAsc();
    List<Hall> findByNameOrderBySeat(String name);

}
