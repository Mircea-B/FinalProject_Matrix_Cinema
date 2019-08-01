package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sda.model.ReservationDTO;
import sda.service.ReservationService;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/get3")
    public List<ReservationDTO> getMethod(@RequestParam("reservations") Integer id) {
        return reservationService.getAllReservations();
    }


}
