package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.ParkingLotOrder;
import com.thoughtworks.parking_lot.model.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotOrderRepository;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class ParkingLotOrderService {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    ParkingLotOrderRepository orderRepository;

    public ParkingLotOrder createOrder(Long parkingLotId, String cartNumber) {
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId).orElse(null);
        if (parkingLot.equals(null) && parkingLot.getCapacity() > parkingLot.getParkingLotOrders().stream().filter(i->i.getStatus()==1).collect(Collectors.toList()).size()) {
            ParkingLotOrder parkingLotOrder = new ParkingLotOrder();
            parkingLotOrder.setCartNumber(cartNumber);
            parkingLotOrder.setStatus(1);
            parkingLotOrder.setStartTime(new Date());
            return orderRepository.save(parkingLotOrder);
        }
        return null;
    }

    public ParkingLotOrder fetchTheCart(Long id, String cartNumber) {
        ParkingLot parkingLot = parkingLotRepository.findById(id).orElse(new ParkingLot());
        ParkingLotOrder parkingLotOrder = (parkingLot.getParkingLotOrders().stream().filter(i -> i.getStatus() == 1 && i.getCartNumber().equals(cartNumber)).collect(Collectors.toList())).get(0);
        if (parkingLotOrder != null) {
            parkingLotOrder.setStatus(0);
            parkingLotOrder.setEndTime(new Date());
            return orderRepository.save(parkingLotOrder);
        }
        return null;
    }
}
