package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parkingLots")
public class ParkingLotController {

    @Autowired
    ParkingLotService parkingLotService;

    @GetMapping
    public ResponseEntity findAllParkingLots () {
        return ResponseEntity.ok(parkingLotService.findAllParkingLots());
    }

    @DeleteMapping
    public ResponseEntity deleteParkingLot(@RequestBody ParkingLot parkingLot) {
        parkingLotService.deleteParkingLot(parkingLot);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findParkingLot (@PathVariable Long id) {
        return ResponseEntity.ok(parkingLotService.findParkingById(id));
    }


    @PutMapping
    public ResponseEntity updateParkingLot (@RequestBody ParkingLot parkingLot) {
        parkingLotService.updateParkingLot(parkingLot);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/pageNumber/{pageNumber}/pageSize/{pageSize}")
    public ResponseEntity findParkingLotByPageSize(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return ResponseEntity.ok(parkingLotService.findAllParkingLotsByPageSize(pageNumber, pageSize));
    }


}
