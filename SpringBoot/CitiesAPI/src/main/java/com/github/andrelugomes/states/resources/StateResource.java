package com.github.andrelugomes.staties.resources;

import com.github.andrelugomes.staties.entities.State;
import com.github.andrelugomes.staties.repositories.StateRepository;
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
@RequestMapping("/states")
public class StateResource {

  private final StateRepository repository;

  public StateResource(final StateRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public Page<State> getStates(Pageable page) {
    return repository.findAll(page);
  }

  @GetMapping("/{id}")
  public ResponseEntity<State> getCountry(@PathVariable Long id) {
    Optional<State> state = repository.findById(id);

    if(state.isPresent()){
      return ResponseEntity.ok().body(state.get());
    } else  {
      return ResponseEntity.notFound().build();
    }
  }
}
