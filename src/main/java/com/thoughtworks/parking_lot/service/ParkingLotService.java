package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    public List<ParkingLot> findAllParkingLots() {
        return parkingLotRepository.findAll();
    }

    public void deleteParkingLot(ParkingLot parkingLot) {
        parkingLotRepository.delete(parkingLot);
    }

    public ParkingLot findParkingById(Long id) {
        return parkingLotRepository.findById(id).orElse(new ParkingLot());
    }

    public void updateParkingLot(ParkingLot parkingLot) {
        if (parkingLot.getCapacity() > 0) parkingLotRepository.save(parkingLot);
    }

    public List<ParkingLot> findAllParkingLotsByPageSize(int pageNumber, int pageSize) {
        return parkingLotRepository.findAll(PageRequest.of(pageNumber - 1, pageSize)).getContent();
    }

    public void createParkingLot(ParkingLot parkingLot) {
        if (parkingLot.getCapacity() > 0) parkingLotRepository.save(parkingLot);
    }
}
