package sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sda.entity.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "select id,name,running from matrix_cinema.movie", nativeQuery = true)

    List<Movie> findByOrderByNameAsc();
}
