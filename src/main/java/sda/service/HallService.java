package sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.entity.Hall;
import sda.model.HallDTO;
import sda.repository.HallRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    @Autowired
    HallRepository hallRepository;

    public HallDTO getHallById(Integer id) {
        Optional<Hall> byId = hallRepository.findById(id);

        if (byId.isPresent()) {
            return new HallDTO(byId.get().name);
        }
        return new HallDTO("Not found");
    }

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
