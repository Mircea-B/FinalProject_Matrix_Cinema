package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import sda.model.HallDTO;
import sda.model.MovieDTO;
import sda.model.ScheduleDTO;
import sda.service.HallService;
import sda.service.MovieService;
import sda.service.ScheduleService;

import java.util.List;

@Controller
public class HallController {

    @Autowired
    HallService hallService;

    @Autowired
    MovieService movieService;

    @Autowired
    ScheduleService scheduleService;


    @GetMapping("/home")
    public String hallPage(Model model) {
       List<HallDTO> halls = hallService.getAllHalls();
        List<MovieDTO> allMovies = movieService.getAllMovies();
        List<ScheduleDTO> allSchedule = scheduleService.getAllSchedules();

        model.addAttribute("halls",halls);
        model.addAttribute("movies",allMovies);
        model.addAttribute("schedules",allSchedule);

       return "home";
    }

    @GetMapping("/home1")
    public List<HallDTO> hal8lPage(Model model) {
        List<HallDTO> allHalls = hallService.getAllHalls();

        System.out.println("Does it work?");

        model.addAttribute("halls", allHalls);
        return allHalls;
    }

    @GetMapping(name = "/hall/json", produces = "application/json")
    @ResponseBody
    public List<HallDTO> getAllHalls() {
        List<HallDTO> allHalls = hallService.getAllHalls();
        System.out.println("Print halls");

        return allHalls;
    }


}
