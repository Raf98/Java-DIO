package one.digitalinnovation.beerstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BeerStockLowerThanZeroException extends Exception {
    public BeerStockLowerThanZeroException(Long id, int quantityToDecrement) {
        super(String.format("Beers with %s ID to decrement informed lowers capacity to less than zero: %s", id, quantityToDecrement));
    }
}
