package kodlama.io.rentAcar;


import kodlama.io.rentAcar.core.utilities.exceptions.ProblemDetails;
import kodlama.io.rentAcar.core.utilities.exceptions.ValidationProblemDetails;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class RentAcarApplication {

	public static void main(String[] args) {



		SpringApplication.run(RentAcarApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessExceptions(ProblemDetails.BusinessException businessException) {
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
	return problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationExceptions(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails=new ValidationProblemDetails();
		validationProblemDetails.setMessage("validation.exception");
		validationProblemDetails.setValidationErrors(new HashMap<>());

		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
	validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
}
		return validationProblemDetails;
	}
@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
//brand marka
//