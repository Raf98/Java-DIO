package one.digitalinnovation.beerstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BeerQuantityGreaterThanMaxBeersException extends Exception{
    public BeerQuantityGreaterThanMaxBeersException(int quantity, int max) {
        super(String.format("Beers can't be inserted as they have quantity %d greater than max quantity %d allowed.", quantity, max));
    }
}
