package sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.entity.Reservation;
import sda.model.ReservationDTO;
import sda.model.ScheduleDTO;
import sda.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public ReservationDTO getReservationById (Integer id) {
        Optional<Reservation> byId = reservationRepository.findById(id);

        if (byId.isPresent()) {
            return new ReservationDTO(byId.get().getId(),byId.get().getRowNumber(),
                    byId.get().getSeatNumber(),byId.get().getScheduleInfo(),
                    byId.get().getReservationCode());
        }
        return new ReservationDTO(byId.get().getId(),0,0,byId.get().getScheduleInfo(),null);
    }

    public List<ReservationDTO> getAllReservations(){
        List<ReservationDTO> allReservation = new ArrayList<>();

        List<Reservation> all = reservationRepository.findAllBy();

        for (Reservation c : all) {
            allReservation.add(new ReservationDTO(c.getId(),c.getRowNumber(),c.getSeatNumber(),
                    c.getScheduleInfo(),c.getReservationCode()));
        }
        return allReservation;
    }

}
