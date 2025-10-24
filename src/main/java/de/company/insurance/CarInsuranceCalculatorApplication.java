package de.company.insurance;

import de.company.insurance.region.RegionProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RegionProperties.class)
public class CarInsuranceCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarInsuranceCalculatorApplication.class, args);
    }

}
