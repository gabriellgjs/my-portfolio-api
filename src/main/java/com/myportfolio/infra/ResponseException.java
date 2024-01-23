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


  public ResponseException(HttpStatus status, String message) {
    this.status = status.value();
    this.message =message;
  }
}
