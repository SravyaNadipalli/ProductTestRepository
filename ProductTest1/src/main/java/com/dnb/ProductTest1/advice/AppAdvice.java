package com.dnb.ProductTest1.advice;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.dnb.ProductTest1.exceptions.IdNotFoundException;
@ControllerAdvice  //which allows handling exceptions across the whole application in one global handling component
public class AppAdvice {
	@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = " invalid id provided")
	@ExceptionHandler(IdNotFoundException.class)
	 public void invalidNameException(IdNotFoundException e){

	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)//handles the exception by this method
	public ResponseEntity<Map<String,String>> handleException(HttpRequestMethodNotSupportedException e)throws IOException
	{
		String provided = e.getMethod();
		List<String> supported= List.of(e.getSupportedMethods());
		String error = provided +"is not one of he supported http mehods("+String.join(",",supported)+")";
		Map<String,String> errorResponse = Map.of("error", error,"message",e.getLocalizedMessage(),"status",HttpStatus.METHOD_NOT_ALLOWED.toString());
		return new ResponseEntity<>(errorResponse,HttpStatus.METHOD_NOT_ALLOWED);
	}

 

}

 

