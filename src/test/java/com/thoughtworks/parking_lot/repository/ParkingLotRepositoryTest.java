package com.thoughtworks.parking_lot.repository;
import com.thoughtworks.parking_lot.model.ParkingLot;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ParkingLotRepositoryTest {

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Test
    public void should_return_parking_lot_by_page_size_and_number_when_call_find_all_parking_lots_gven_15() {
        parkingLotRepository.save(new ParkingLot());
        parkingLotRepository.save(new ParkingLot());

        List<ParkingLot> parkingLots = parkingLotRepository.findAll(PageRequest.of(0,15)).getContent();
        Assertions.assertEquals(2, parkingLots.size());
    }

    @Test
    public void should_return_parking_lot_by_page_size_and_number_when_call_find_all_parking_lots_1() {
        parkingLotRepository.save(new ParkingLot());
        parkingLotRepository.save(new ParkingLot());

        List<ParkingLot> parkingLots = parkingLotRepository.findAll(PageRequest.of(0,1)).getContent();
        Assertions.assertEquals(1, parkingLots.size());
    }
}