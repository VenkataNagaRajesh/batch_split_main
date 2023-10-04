package com.ceva.batch.split.exception;

import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class InvalidInputException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  String message;

  public InvalidInputException(String message) {
    super(message);
    this.message = message;
  }

}
