package com.NicksWorld.JpaBiDirectional;

import com.NicksWorld.JpaBiDirectional.model.Car;
import com.NicksWorld.JpaBiDirectional.model.Owner;
import com.NicksWorld.JpaBiDirectional.repository.CarRepository;
import com.NicksWorld.JpaBiDirectional.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.Optional;

@SpringBootApplication                        //must have this or you'll get a "missing ServletWebServerFactory bean" error
public class JpaBiDirectionalApplication {
	private static final Logger log = LoggerFactory.getLogger(JpaBiDirectionalApplication.class);   // this puts it as if its one of the "load line" when you run the program, ( it wont look like a regular print statement but it'll be there, you just gotta look)

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(JpaBiDirectionalApplication.class, args);

		CarRepository carRepository = configurableApplicationContext.getBean(CarRepository.class);
		OwnerRepository ownerRepository = configurableApplicationContext.getBean(OwnerRepository.class);

		Car car = new Car("m200");
		carRepository.save(car);

		Owner owner = new Owner("John Doe");
		owner.setCar(car);
		ownerRepository.save(owner);


	Optional<Car> optionalCar = carRepository.findById(1L);        //finds car by its id (1L)
	Optional<Owner> optionalOwner = ownerRepository.findById(2L);  //finds owner by its id (2L)

	if( optionalCar.isPresent() && optionalOwner.isPresent() ) {
		log.info(optionalCar.get() + " is owned by: " + optionalCar.get().getOwner());   //this finds the car by using the "optionalCar" which finds the car by using it's id which we put in the CarRepository
		log.info(optionalOwner.get() + " has a car: " + optionalOwner.get().getCar());
	}

}
}
