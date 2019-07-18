package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.model.Order;
import com.thoughtworks.parking_lot.repository.OrderRepository;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderService {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Long parkingLotId, String cartNumber) {
        if(!parkingLotRepository.findById(parkingLotId).orElse(null).equals(null)) {
            Order order = new Order();
            order.setCartNumber(cartNumber);
            order.setStatus(1);
            order.setStartTime(new Date());
            return orderRepository.save(order);
        }
        return null;
    }
}
