package com.myportfolio.infra;

import lombok.Getter;
import lombok.Setter;

import org.springframework.http.HttpStatus;
import java.util.Map;


@Getter
@Setter
public class ResponseException {
  private int status;
  private String message;
  private Map<String, String> errors;


  public ResponseException(HttpStatus status, String message, Map<String, String> errors) {
    this.status = status.value();
    this.message =message;
    this.errors = errors;
  }
}
