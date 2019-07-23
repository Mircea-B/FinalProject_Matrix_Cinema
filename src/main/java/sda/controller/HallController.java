package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import sda.model.HallDTO;
import sda.service.HallService;

import java.util.List;

@Controller
public class HallController {

    @Autowired
    HallService hallService;

    @GetMapping("/halls/{hallName}")
    public String hallPage(Model model, @PathVariable("hallName") String hallName) {
        HallDTO hallByName = (HallDTO) hallService.getHallByName(hallName);

        model.addAttribute("hallName",hallByName.name);
        return "home";
    }

    @GetMapping("/halls")
    public String hallPage(Model model) {
        List<HallDTO> allHalls = hallService.getAllHalls();

        System.out.println("Does it work?");

        model.addAttribute("halls", allHalls);
        return "home2";
    }

    @GetMapping(name = "/halls/json", produces = "application/json")
    @ResponseBody
    public List<HallDTO> getAllHalls() {
        List<HallDTO> allHalls = hallService.getAllHalls();
        System.out.println("Print halls");

        return allHalls;
    }


}
