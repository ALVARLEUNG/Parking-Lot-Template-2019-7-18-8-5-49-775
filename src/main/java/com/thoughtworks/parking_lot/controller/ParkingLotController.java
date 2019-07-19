package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.model.ParkingLotOrder;
import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.service.OrderService;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkingLots")
public class ParkingLotController {

    @Autowired
    ParkingLotService parkingLotService;

    @Autowired
    OrderService orderService;

    @PostMapping
    public void createParkingLot(@RequestBody ParkingLot parkingLot) {
        parkingLotService.createParkingLot(parkingLot);
    }

    @GetMapping
    public List<ParkingLot> findAllParkingLots() {
        return parkingLotService.findAllParkingLots();
    }

    @DeleteMapping
    public void deleteParkingLot(@RequestBody ParkingLot parkingLot) {
        parkingLotService.deleteParkingLot(parkingLot);
    }

    @GetMapping("/{id}")
    public ParkingLot findParkingLot(@PathVariable Long id) {
        return parkingLotService.findParkingById(id);
    }


    @PutMapping
    public void updateParkingLot(@RequestBody ParkingLot parkingLot) {
        parkingLotService.updateParkingLot(parkingLot);
    }

    @GetMapping("/pageNumber/{pageNumber}/pageSize/{pageSize}")
    public List<ParkingLot> findParkingLotByPageSize(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return parkingLotService.findAllParkingLotsByPageSize(pageNumber, pageSize);
    }

    @PostMapping("/{id}/orders/{cartNumber}")
    public ParkingLotOrder createOrder(@PathVariable Long id, @PathVariable String cartNumber) {
        return orderService.createOrder(id, cartNumber);
    }

    @PutMapping("/{id}/orders/{cartNumber}")
    public ParkingLotOrder fetchTheCart(@PathVariable Long id, @PathVariable String cartNumber) {
        return orderService.fetchTheCart(id, cartNumber);
    }



}
