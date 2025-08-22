package exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException  ex){
		ErrorResponse errorResponse = new ErrorResponse(
	            404,
	            "The request resource not found.",
	            ex.getMessage(),
	            LocalDateTime.now()
	        );
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
	        ErrorResponse errorResponse = new ErrorResponse(
	            500,
	            "An unexpected error occurred.",
	            ex.getMessage(),
	            LocalDateTime.now()
	        );
	        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }

}
