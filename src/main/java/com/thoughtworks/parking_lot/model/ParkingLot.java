package com.thoughtworks.parking_lot.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "capacity")
    @Min(value = 0)
    private int capacity;

    @Column(name = "position")
    private String position;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "name")
    List<ParkingLotOrder> parkingLotOrders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<ParkingLotOrder> getParkingLotOrders() {
        return parkingLotOrders;
    }

    public void setParkingLotOrders(List<ParkingLotOrder> parkingLotOrders) {
        this.parkingLotOrders = parkingLotOrders;
    }
}
