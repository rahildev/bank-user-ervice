package az.kapitalbank.birbankuser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundExeption extends RuntimeException {

    public UserNotFoundExeption(String message) {
        super(message);
    }
}
