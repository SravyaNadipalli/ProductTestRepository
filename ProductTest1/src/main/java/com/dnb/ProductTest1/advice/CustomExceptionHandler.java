package com.dnb.ProductTest1.advice;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
//This class is use for handling our custom exceptions
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		Map<String,Object> responsBody = new HashMap<>();
		responsBody.put("timestamp", LocalDate.now());
		responsBody.put("status", status.value());

		List<String> errortype =  ex.getBindingResult().
				getFieldErrors().
				stream().
				map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		responsBody.put("errors", errortype);
		return new ResponseEntity<Object>(responsBody, headers, status);
	}

	

 

}

 

