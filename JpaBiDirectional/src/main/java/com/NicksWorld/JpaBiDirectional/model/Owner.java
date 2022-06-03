package com.NicksWorld.JpaBiDirectional.model;


import javax.persistence.*;

@Entity
@Table (name = "Owner")
public class Owner {

    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)

    private Long id;
    private String name;

    @OneToOne
    @JoinColumn ( referencedColumnName = "id", name = "car_id")
    private Car car;

    public Owner() {
    }

    public Owner(String name) {
        this.name = name;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
