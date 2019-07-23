package sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import sda.entity.Hall;
import sda.model.HallDTO;
import sda.repository.HallRepository;

import java.util.ArrayList;
import java.util.List;

public class HallService {

    @Autowired
    HallRepository hallRepository;

    public List<HallDTO> getAllHalls() {
        List<HallDTO> allHalls = new ArrayList<>();

        List<Hall> hallList = hallRepository.findAllByOrderByIdAsc();

        for (Hall a : hallList) {
            allHalls.add(new HallDTO(a.name));

        }
        return allHalls;
    }

    public List<HallDTO> getHallByName(String name) {
        List<HallDTO> allHallsByName = new ArrayList<>();
        List<Hall> hallList = hallRepository.findByNameOrderBySeatAsc(name);
        for (Hall a : hallList) {
            allHallsByName.add(new HallDTO(a.getName()));
        }
        return allHallsByName;

    }
}
