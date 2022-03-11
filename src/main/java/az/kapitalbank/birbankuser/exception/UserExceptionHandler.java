package az.kapitalbank.birbankuser.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLClientInfoException;
import java.util.Date;


@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundExeption.class)
    public final ResponseEntity<ErrorMessage> handleUserNotFoundException(UserNotFoundExeption ex, WebRequest request) {
        ErrorMessage exceptionResponse = new ErrorMessage(new Date(), ex.getMessage(),
                request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public final ResponseEntity<ErrorMessage> handleSqlError(SQLClientInfoException e,
                                                             WebRequest request) {
        ErrorMessage message = new ErrorMessage(new Date(), e.getMessage(),
                request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
    @ExceptionHandler(NullPointerException.class)
    public final ResponseEntity<ErrorMessage> handleDbEmptyError(NullPointerException e, WebRequest request){
        ErrorMessage message = new ErrorMessage(new Date(), e.getMessage(),request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
