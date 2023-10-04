package com.ceva.batch.split.exception;

import org.springframework.http.HttpStatus;

public class InvalidInputErrorResponse {
  int code;
  String message;

  /**
   * constructor.
   * 
   */
  public InvalidInputErrorResponse(int code, String message) {
    super();
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "InvalidInputErrorResponse [code=" + code + ", message=" + message + "]";
  }


}
