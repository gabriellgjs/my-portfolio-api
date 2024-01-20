package com.myportfolio.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.springframework.http.HttpStatus;


@Getter
@Setter
public class ResponseException {
  private int status;
  private String message;


  public ResponseException(HttpStatus status, String message) {
    this.status = status.value();
    this.message =message;
  }
}
