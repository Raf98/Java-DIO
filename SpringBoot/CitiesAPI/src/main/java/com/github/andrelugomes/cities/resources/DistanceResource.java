package com.github.andrelugomes.cities.resources;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.github.andrelugomes.cities.repositories.CityRepository;
import com.github.andrelugomes.cities.service.DistanceService;
import com.github.andrelugomes.cities.service.EarthRadius;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/distances")
public class DistanceResource {

  Logger log = LoggerFactory.getLogger(DistanceResource.class);

  private final DistanceService service;
  private final CityRepository cityRepository;

  public DistanceResource(DistanceService service, CityRepository cityRepository) {
    this.service = service;
    this.cityRepository = cityRepository;
  }

  @GetMapping("/by-points")
  public  String byPoints(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
    log.info("byPoints");

    String city1Name = cityRepository.findById(city1).get().getName();
    String city2Name = cityRepository.findById(city2).get().getName();

    return "Distance in miles from " + city1Name + " to " + city2Name + " is: " +  
            BigDecimal.valueOf(service.distanceByPointsInMiles(city1, city2))
            .setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

  @GetMapping("/by-cube")
  public String byCube(@RequestParam(name = "from") final Long city1,
                       @RequestParam(name = "to") final Long city2) {
    log.info("byCube");

    String city1Name = cityRepository.findById(city1).get().getName();
    String city2Name = cityRepository.findById(city2).get().getName();

    return "Distance in meters from " + city1Name + " to " + city2Name + " is: " +  
            BigDecimal.valueOf(service.distanceByCubeInMeters(city1, city2))
            .setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

  @GetMapping("/by-math")
  public String byMath(@RequestParam(name = "from") final Long city1,
                                @RequestParam(name = "to") final Long city2,
                                @RequestParam final EarthRadius unit) {
    log.info("byMath");

    String city1Name = cityRepository.findById(city1).get().getName();
    String city2Name = cityRepository.findById(city2).get().getName();

    return "Distance (using math; by " + unit.toString().toLowerCase() + ") from " + city1Name + " to " + city2Name + " is: " +  
            BigDecimal.valueOf(service.distanceUsingMath(city1, city2, unit))
            .setScale(2, RoundingMode.HALF_UP).doubleValue();
  }
}
