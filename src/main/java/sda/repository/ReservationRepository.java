package sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sda.entity.Reservation;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Query(value = "select * from matrix_cinema.reservation", nativeQuery = true)
    List<Reservation> findAllBy();
}
