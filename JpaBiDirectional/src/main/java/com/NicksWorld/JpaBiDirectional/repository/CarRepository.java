package com.NicksWorld.JpaBiDirectional.repository;

import com.NicksWorld.JpaBiDirectional.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository <Car, Long> {
}
