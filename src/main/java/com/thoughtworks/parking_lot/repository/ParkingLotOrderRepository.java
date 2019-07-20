package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.model.ParkingLotOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotOrderRepository extends JpaRepository<ParkingLotOrder, Long> {
}