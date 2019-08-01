package sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.entity.Movie;
import sda.model.MovieDTO;
import sda.repository.MovieRepository;
import sda.repository.ScheduleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieDTO getMovieById(Integer id) {
        Optional<Movie> byId = movieRepository.findById(id);

        if (byId.isPresent()) {
            return new MovieDTO(byId.get().name,id,byId.get().getRunning());
        }
        return new MovieDTO("Not found!",0,0);
    }

    public List<MovieDTO> getAllMovies(){

        List<MovieDTO> allMovies = new ArrayList<>();

        List<Movie> all = movieRepository.findByOrderByNameAsc();

        for (Movie a : all){
            allMovies.add(new MovieDTO(a.getName(),a.getId(), a.getRunning()));
        }
        return allMovies;
    }


}
