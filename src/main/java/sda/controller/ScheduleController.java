package sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sda.model.ScheduleDTO;
import sda.service.ScheduleService;

import java.util.List;

@Controller
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/get2")
    public List<ScheduleDTO> getMethod(@RequestParam("schedules")Integer id) {
        return scheduleService.getAllSchedules();
    }
}
