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

    @GetMapping("/hall/{halls}")
    public String hallPage(Model model, @PathVariable("halls") Integer hallsId) {
       HallDTO hallByName = hallService.getHallById(hallsId);

       model.addAttribute("hall",hallByName);

       return "home";
    }

    @GetMapping("/home")
    public List<HallDTO> hallPage(Model model) {
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
