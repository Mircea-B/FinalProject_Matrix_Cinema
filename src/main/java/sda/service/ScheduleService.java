package sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.entity.Schedule;
import sda.model.ScheduleDTO;
import sda.repository.ScheduleRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public ScheduleDTO getScheduleById(Integer id){
        Optional<Schedule> byId = scheduleRepository.findById(id);

        if (byId.isPresent()) {
            return new ScheduleDTO(byId.get().getId(),byId.get().getDate(),byId.get().getMovieName(),byId.get().getHallName());
        }
        return new ScheduleDTO(0,null,byId.get().getMovieName(),byId.get().getHallName());
    }

    public List<ScheduleDTO> getAllSchedules(){
        List<ScheduleDTO> allSchedule = new ArrayList<>();

        List<Schedule> all = scheduleRepository.findAll();

        for (Schedule b : all) {
            allSchedule.add(new ScheduleDTO(b.getId(),b.getDate(),b.getMovieName(),b.getHallName()));
        }
        return allSchedule;
    }

}
