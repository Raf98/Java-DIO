package com.github.andrelugomes.countries.resources;

import com.github.andrelugomes.countries.entities.Country;
import com.github.andrelugomes.countries.repositories.CountryRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/countries")
public class CountryResource {

  private final CountryRepository repository;

  public CountryResource(final CountryRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Page<Country> getCountries(Pageable page) {

    return repository.findAll(page);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Country> getCountry(@PathVariable Long id) {
    Optional<Country> country = repository.findById(id);

    if(country.isPresent()){
      return ResponseEntity.ok().body(country.get());
    } else  {
      return ResponseEntity.notFound().build();
    }
  }
}
