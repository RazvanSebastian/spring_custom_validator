package edu.validation.demo.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	ResponseEntity<ExceptionBody> handleConstraintViolationException(ConstraintViolationException e) {
		ExceptionBody exceptionBody = new ExceptionBody(e.toString(), dateFormat.format(new Date()), e.getMessage(),
				HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name());
		return new ResponseEntity<ExceptionBody>(exceptionBody, HttpStatus.BAD_REQUEST);
	}

	static final class ExceptionBody {

		private String exceptionName;
		private String date;
		private String message;
		private int statusCode;
		private String httpStatus;

		public ExceptionBody(String exceptionName, String date, String message, int statusCode, String httpStatus) {
			super();
			this.exceptionName = exceptionName;
			this.date = date;
			this.message = message;
			this.statusCode = statusCode;
			this.httpStatus = httpStatus;
		}

		public String getExceptionName() {
			return exceptionName;
		}

		public String getDate() {
			return date;
		}

		public String getMessage() {
			return message;
		}

		public int getStatusCode() {
			return statusCode;
		}

		public String getHttpStatus() {
			return httpStatus;
		}

	}
}
