package home.udemy.spring.springboot.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import home.udemy.spring.springboot.pojo.ExceptionResponse;

@ControllerAdvice
@RestController
public class HomeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public final ExceptionResponse handleAllException(Exception ex, WebRequest request) throws Exception{
		return new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public final ExceptionResponse handleUserNotFoundExceptionException(UserNotFoundException ex, WebRequest request) throws Exception{
		return new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false),HttpStatus.NOT_FOUND);
	}
}
