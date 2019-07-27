package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sda.model.MovieDTO;
import sda.service.MovieService;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    /*
    @GetMapping("/movie/{movies")
    public String moviePage(Model model, @PathVariable("movies") Integer id) {
        MovieDTO movieById = movieService.getMovieById(id);

        model.addAttribute("movie", movieById.name);
        return "movies";
    }

    @GetMapping("/movies/page")
    public String moviePage(Model model) {
        List<MovieDTO> allMovies = movieService.getAllMovies();

        model.addAttribute("movies", allMovies);

        return "movies";
    }

    @RequestMapping(value = "/", method = POST)
    @ResponseBody
    public List<MovieDTO> getAllMovies() {
        List<MovieDTO> allMovies = movieService.getAllMovies();
        System.out.println("Printing movies");

        return allMovies;
    }
    */

    @GetMapping("/get")
    public List<MovieDTO> getMethod(@RequestParam("movies") int id) {
        return movieService.getAllMovies();
    }
}
