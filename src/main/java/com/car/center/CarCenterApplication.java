package com.car.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({
	"com.car.center.model"
})
public class CarCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarCenterApplication.class, args);
	}

}
