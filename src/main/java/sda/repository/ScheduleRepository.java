package sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import sda.entity.Schedule;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    @Query(value = "select * from matrix_cinema.schedule", nativeQuery = true)
    List<Schedule> findAllBy();
}
